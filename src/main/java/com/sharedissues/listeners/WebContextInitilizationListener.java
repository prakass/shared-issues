package com.sharedissues.listeners;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sharedissues.entities.Person;
import com.sharedissues.service.CommonService;

public class WebContextInitilizationListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent args) {
		
	}

	
	@Override
	public void contextInitialized(ServletContextEvent args) {
		/*Create superadmin*/
		try{
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(args.getServletContext());
		CommonService commonService  =(CommonService) context.getBean("commonService");
		Person person = new Person();
		person.setEmail("superadmin");
		person.setFirstName("Super");
		person.setLastName("Admin");
		person.setPassword("superadminDemoAccess123");
		person.addRole("SUPERADMIN");
		person.addRole("USER");
		person.addRole("ADMIN");
		commonService.persist(person);
		System.out.println("Superadmin created.......");
		}catch(Exception e){
			System.out.println("Superadmin already exists.");
		}
		System.out.println("Bootstrap ready");
	}
}
