package com.sharedissues.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sharedissues.all.common.WebUtility;
import com.sharedissues.entities.Person;

@Controller
public class CommonController extends WebUtility{
	@RequestMapping("profile")
	public ModelAndView doGetUserProfile(HttpServletRequest request)
	{
		Person person = (Person)request.getSession().getAttribute("current.person");
		ModelAndView mav =new ModelAndView("/users/profile","person",person);
		return mav;
	
	}
	
	@RequestMapping("upload-image")
	public void doGetImage(HttpServletRequest request,HttpServletResponse response)
	{
		Person person = (Person)request.getSession().getAttribute("current.person");
		ModelAndView mav =new ModelAndView("/users/profile","person",person);
		
	}
	
}
