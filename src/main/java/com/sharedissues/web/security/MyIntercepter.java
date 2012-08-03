package com.sharedissues.web.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sharedissues.entities.Person;
import com.sharedissues.service.CommonService;

public class MyIntercepter extends HandlerInterceptorAdapter  {
	ActivityObserver activityObserver;
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		if(request.getRequestURI().contains("/action/")){
		  if(request.getSession().getAttribute("current.person")==null){
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			Person person = new Person();
			ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
			CommonService commonService  =(CommonService)context.getBean("commonService");
			request.getSession().setAttribute("current.person",commonService.getObject(person, username) );
		 }
		}
		
		activityObserver.observeActivity(request,response);
		
		
		return true;
	}

	public ActivityObserver getActivityObserver() {
		return activityObserver;
	}

	public void setActivityObserver(ActivityObserver activityObserver) {
		this.activityObserver = activityObserver;
	}

	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		
	}
}
