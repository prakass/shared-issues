package com.sharedissues.web.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.sharedissues.service.ServiceSupport;

@Service
public class ActivityObserver extends ServiceSupport{
	public void observeUsersActivity(HttpServletRequest request){
		
	}
	
	public void observeIssueActivity(HttpServletRequest request){
		
	}
	
	public void observeActivity(HttpServletRequest request,HttpServletResponse response){
		
	}
	
}
