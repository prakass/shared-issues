package com.sharedissues.all.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.sharedissues.entities.Person;

@Service
public class WebUtility {
	public void addServerError(HttpServletRequest request,String error){
		request.getSession().setAttribute("server-error", error);
	}
	
	public void addServerSuccessMessage(HttpServletRequest request,String error){
		request.getSession().setAttribute("success-message", error);
	}
	
	public void storePersonToSession(HttpServletRequest request,Person person){
		request.getSession().setAttribute("current.person",person);
	}
	
	
}
