package com.sharedissues.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sharedissues.all.common.PasswordEncoder;
import com.sharedissues.all.common.WebUtility;
import com.sharedissues.entities.Person;
import com.sharedissues.service.ServiceSupport;

@Controller
public class CommonController extends ServiceSupport{
	@Autowired
	WebUtility webUtility;
	
	@RequestMapping("profile")
	public ModelAndView doGetUserProfile(HttpServletRequest request)
	{
		Person person = (Person)request.getSession().getAttribute("current.person");
		ModelAndView mav =new ModelAndView("/users/profile","person",person);
		ShaPasswordEncoder encode = new ShaPasswordEncoder();
		return mav;
	
	}
	
	@RequestMapping("upload-image")
	public void doGetImage(HttpServletRequest request,HttpServletResponse response)
	{
		Person person = (Person)request.getSession().getAttribute("current.person");
		ModelAndView mav =new ModelAndView("/users/profile","person",person);
		
	}
	
	@RequestMapping(value="contact",method=RequestMethod.GET)
	public ModelAndView doGetContact(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		ModelAndView mav =new ModelAndView("/users/contact");
		return mav;
	}
	
	@RequestMapping(value="contact",method=RequestMethod.POST)
	public void doPostContact(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		webUtility.addServerSuccessMessage(request, "We have received your message. We will try to process it soon.");
		response.sendRedirect(request.getParameter("target"));
	}
	@RequestMapping(value="change-password",method=RequestMethod.GET)
	public ModelAndView doGetChangePassword(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		ModelAndView mav =new ModelAndView("/users/change-password");
		return mav;
		
	}
	
	@RequestMapping(value="change-password",method=RequestMethod.POST)
	public void doPostChangePassword(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		try{
			Person person = (Person)request.getSession().getAttribute("current.person");
			String password = request.getParameter("password");
			person.setPassword(PasswordEncoder.encode(person.getEmail(), password));
			getCommonService().update(person);
			request.getSession().setAttribute("current.person",person);
			webUtility.addServerSuccessMessage(request, "Your password is changed");
		}catch(Exception e) {
			webUtility.addServerError(request, e.getMessage());
		}
		response.sendRedirect("/action/profile");
	}
	
	@RequestMapping(value="edit-profile",method=RequestMethod.GET)
	public ModelAndView doGetEdit(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		
		Person person = (Person)request.getSession().getAttribute("current.person");
		ModelAndView mav = new ModelAndView("/users/edit-profile","person",person);
		return mav;
	}
	
	@RequestMapping(value="edit-profile",method=RequestMethod.POST)
	public ModelAndView doPostEdit(HttpServletRequest request,Person person,HttpServletResponse response) throws IOException
	{
		String[] roles = request.getParameterValues("roles");
		person.setRoles("");
		for(String role:roles){
			person.addRole(role);
		}
		try{
			getCommonService().update(person);
			webUtility.addServerSuccessMessage(request, "Changes saved");
		}catch(Exception e){
			webUtility.addServerError(request, e.getMessage());
		}
		request.getSession().setAttribute("current.person", person);
		response.sendRedirect("/action/profile");
		return null;
	}
	
	@RequestMapping(value="remove-activity",method=RequestMethod.GET)
	public void doGetRemoveActivity(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String activityId = request.getParameter("activityId");
		getCommonService().remove("activity", "activityId", activityId);
		response.sendRedirect("/action/issues/index");
	}
	
	
	
}
