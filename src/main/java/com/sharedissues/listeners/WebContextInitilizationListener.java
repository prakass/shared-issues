package com.sharedissues.listeners;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sharedissues.all.common.PasswordEncoder;
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
		person.setPassword("1f5bc8c7ceebb43c21ecdbc9c0bd48dc1eae5bb09cc4e75304a145f632b9dd51e405a1d43d77440a8d506bd27d648de2c59b4138d8a3b4f41ad1e1006f464fb9");
		person.addRole("SUPERADMIN");
		person.addRole("USER");
		person.addRole("ADMIN");
		commonService.persist(person);
		
		System.out.println("Superadmin created.......");
		}catch(Exception e){
			System.out.println("Superadmin already exists.");
		}
		System.out.println("Enviroment setup ready.");
	}
}
