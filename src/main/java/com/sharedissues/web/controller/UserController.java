package com.sharedissues.web.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sharedissues.all.common.MyService;
import com.sharedissues.all.common.PasswordEncoder;
import com.sharedissues.all.common.WebUtility;
import com.sharedissues.entities.Person;

@Controller
@RequestMapping("/users")
public class UserController extends MyService{
	@Autowired
	WebUtility webUtility;
	
	@RequestMapping(value="add-user",method=RequestMethod.GET)
	public ModelAndView doGetAddUser(HttpServletRequest request){
		Person person =new Person();
		ModelAndView mav = new ModelAndView("/users/add-user","person",person);
		return mav;
	}
	@RequestMapping(value="add-user",method=RequestMethod.POST)
	public ModelAndView doPostAddUser(Person person,HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/users/add-user");
		person.setPassword(PasswordEncoder.encode(person.getEmail(), request.getParameter("password1")));
		try{
			getCommonService().persist(person);
			webUtility.addServerSuccessMessage(request, "New user added successfully");
			mav.addObject("person",new Person());
		}catch(Exception e){
			webUtility.addServerError(request, "Could not add user! Please check your email it should be unique.");
			mav.addObject("person",person);
		}
		return mav;
	}
	
	@RequestMapping(value="all-users",method=RequestMethod.GET)
	public ModelAndView doPostAllUsers(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/users/all-users");
		Person p =new Person();
		List<Object> persons =getCommonService().getObjects(p, "person");
		mav.addObject("persons",persons);
		mav.addObject("totleUser",persons.size());
		return mav;
	}
	
	@RequestMapping(value="search-user",method=RequestMethod.GET)
	public String doGetSearchUser(HttpServletRequest request){
		return "/users/search-user";
	}
	
	@RequestMapping(value="search-user",method=RequestMethod.POST)
	public ModelAndView doPostSearchUser(HttpServletRequest request){
		String query = request.getParameter("query");
		List<Object> persons = getPersonReadService().findPersonByQuery(query);
		ModelAndView mav =new ModelAndView("/users/search-user","persons",persons);
		mav.addObject("totleUser",persons.size());
		return mav;
	}
	
	@RequestMapping(value="edit-user",method=RequestMethod.GET)
	public ModelAndView doGetEditUser(HttpServletRequest request){
		String email = request.getParameter("email");
		Person p =new Person();
		ModelAndView mav = new ModelAndView("/users/edit-user","person",getCommonService().getObject(p, email));
		return mav;
	}
	
	@RequestMapping(value="edit-user",method=RequestMethod.POST)
	public String doPostEditUser(HttpServletRequest request,Person person,HttpServletResponse response) throws IOException{
		String[] roles = request.getParameterValues("roles");
		person.setRoles("");
		if(roles!=null){
			for(String role:roles){
				person.addRole(role);
			}
		}
		try{
			getCommonService().update(person);
			webUtility.addServerSuccessMessage(request, "Changes saved");
		}catch(Exception e){
			webUtility.addServerError(request, e.getMessage());
		}
		response.sendRedirect(request.getRequestURI()+"?email="+person.getEmail());
		return null;
	}
	@RequestMapping(value="remove-user",method=RequestMethod.GET)
	public String doDeleteEditUser(HttpServletRequest request,Person person,HttpServletResponse response) throws IOException{
		String email = request.getParameter("email");
		if(person.getEmail().equalsIgnoreCase("superadmin")){
			webUtility.addServerError(request, "No one can remove superadmin");
			response.sendRedirect("/action/users/all-users");
			return null;
		}
		try{
			getCommonService().remove("person","email",email);
			webUtility.addServerSuccessMessage(request, "User removed");
		}catch(Exception e){
			webUtility.addServerError(request, e.getMessage());
		}
		response.sendRedirect("/action/users/all-users");
		return null;
	}
	
	@RequestMapping(value="configure-roles",method=RequestMethod.GET)
	public ModelAndView doGetConfigureRole(HttpServletRequest request,HttpServletResponse response) {
		Person p = new Person();
		List<Object> persons = getCommonService().getObjects(p, "person");
		ModelAndView mav =new ModelAndView("/users/configure-roles","persons",persons);
		return mav;
	}
	
	@RequestMapping(value="configure-roles",method=RequestMethod.POST)
	public String doPostConfigureRole(HttpServletRequest request,HttpServletResponse response) throws IOException{
		ModelAndView mav =new ModelAndView("/users/configure-roles");
		Person p =new Person();
		String email = request.getParameter("email");
		Person person = (Person)getCommonService().getObject(p, email);
		String[] roles = request.getParameterValues("roles");
		person.setRoles("");
		for(String role:roles){
			person.addRole(role);
		}
		getCommonService().update(person);
		response.sendRedirect(request.getRequestURI());
		return null;
	}
	
	
	@RequestMapping(value="upload-image",method=RequestMethod.GET)
	public String doPostUploadImage(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Person person =(Person)request.getSession().getAttribute("current.person");
		String imageUuid= request.getParameter("imageUuid");
		person.setProfilePicture(imageUuid);
		getCommonService().update(person);
		request.getSession().setAttribute("current.person",getCommonService().getObject(person, person.getEmail()));
		response.sendRedirect("/action/profile");
		return null;
	}
}
