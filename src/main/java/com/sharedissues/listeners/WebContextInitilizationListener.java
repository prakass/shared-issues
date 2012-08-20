package com.sharedissues.listeners;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sharedissues.all.common.PasswordEncoder;
import com.sharedissues.entities.Person;
import com.sharedissues.service.CommonService;

public class WebContextInitilizationListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent args) {
		
	}

	
	public void contextInitialized(ServletContextEvent args) {
		/*Create superadmin*/
		try{
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(args.getServletContext());
		CommonService commonService  =(CommonService) context.getBean("commonService");
		Person person = new Person();
		person.setEmail("superadmin");
		person.setFirstName("Super");
		person.setLastName("Admin");
		person.setPassword("f69a16e601df2a1a68418ec655f2eedccec8e378e8d367c5018d3399d8812b709b5adee68e7d2b457d6e3849d0058d0daa9eb6f2bb23bb9a168d1445bfa4d327");
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
