package com.sharedissues.web.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sharedissues.entities.Person;
import com.sharedissues.entities.Visit;
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
		
		//Set selected tab
		handleTab(request);
		
		return true;
	}

	public ActivityObserver getActivityObserver() {
		return activityObserver;
	}

	@Autowired
	public void setActivityObserver(ActivityObserver activityObserver) {
		this.activityObserver = activityObserver;
	}

	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		
	}
	
	private void handleTab(HttpServletRequest request){
		String uri = request.getRequestURI();
		if(uri.contains("users")) {
			request.getSession().setAttribute("tab", "users");
		}else if(uri.contains("issues")){
			request.getSession().setAttribute("tab", "issues");
		}else if(uri.contains("contact")){
			request.getSession().setAttribute("tab", "contact");
		}else if(uri.contains("all-images")){
			request.getSession().setAttribute("tab", "files");
		}else if(uri.contains("edit-profile")||uri.contains("change-password")||uri.contains("profile")){
			request.getSession().setAttribute("tab", "profile");
		}
	}
	
	
	
}
