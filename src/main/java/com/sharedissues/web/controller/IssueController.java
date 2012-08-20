package com.sharedissues.web.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.mongodb.util.WeakBag;
import com.sharedissues.all.common.WebUtility;
import com.sharedissues.entities.Activity;
import com.sharedissues.entities.Comment;
import com.sharedissues.entities.Issue;
import com.sharedissues.entities.Person;
import com.sharedissues.service.ServiceSupport;

@Controller
@RequestMapping("issues")
public class IssueController extends ServiceSupport{
	@Autowired
	WebUtility webUtility;
	
	@RequestMapping(value="index",method=RequestMethod.GET)
	public ModelAndView doGetDashBoard(){
		ModelAndView mav =new ModelAndView("/issues/index","issues",getCommonService().getObjects(new Issue(), "issue"));
		List list = getCommonService().getObjects(new Activity(),"activity");
		Collections.sort(list);
		mav.addObject("activities",list);
		return mav;
	}
	@RequestMapping(value="create",method=RequestMethod.GET)
	public ModelAndView doGetAddIssue(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView("/issues/add","issue",new Issue());
		mav.addObject("persons", getCommonService().getObjects(new Person(), "person"));
		return mav;
	}
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public void doPostAddIssue(@ModelAttribute("issue")Issue issue,HttpServletRequest request,HttpServletResponse response) throws IOException{
		getCommonService().persist(issue);
		webUtility.addServerSuccessMessage(request, "New issue created");
		response.sendRedirect(request.getRequestURI());
	}
	
	@RequestMapping(value="edit",method=RequestMethod.GET)
	public ModelAndView doGetEditIssue(HttpServletResponse response, HttpServletRequest request){
		ModelAndView mav =new ModelAndView("/issues/edit","issue",getCommonService().getObject(new Issue(), request.getParameter("issueUuid")));
		mav.addObject("persons", getCommonService().getObjects(new Person(), "person"));
		return mav;
	}
	
	@RequestMapping(value="edit",method=RequestMethod.POST)
	public void doPostEditIssue(Issue issue,HttpServletRequest request,HttpServletResponse response) throws IOException{
		getCommonService().update(issue);
		webUtility.addServerSuccessMessage(request,"Changes saved");
		response.sendRedirect("/action/issues/detail?issueUuid="+issue.getIssueUuid());
		
	}
	
	
	@RequestMapping(value="remove",method=RequestMethod.GET)
	public void doGetDeleteIssue(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String issueUuid = request.getParameter("issueUuid");
		getCommonService().remove("issue", "issue_uuid", issueUuid);
		webUtility.addServerSuccessMessage(request, "Task successfully removed");
		response.sendRedirect("/action/issues/index");
	}
	
	@RequestMapping(value="search",method=RequestMethod.GET)
	public ModelAndView doGetSearchIssue(){
		return null;
	}
	
	@RequestMapping(value="search",method=RequestMethod.POST)
	public ModelAndView doPostSearchIssue(){
		return null;
	}
	
	
	@RequestMapping(value="issue-board",method=RequestMethod.GET)
	public ModelAndView doGetIssueBoard(){
		ModelAndView mav =new ModelAndView("/issues/issue-board","issues",getCommonService().getObjects(new Issue(), "issue"));
		return mav;
	}
	
	@RequestMapping(value="detail",method=RequestMethod.GET)
	public ModelAndView doGetIssueDetail(HttpServletRequest request){
		String issueUuid = request.getParameter("issueUuid");
		Issue issue = (Issue)getCommonService().getObject(new Issue(), issueUuid);
		ModelAndView mav = new ModelAndView("/issues/detail","issue",issue);
		if(issue.getStatus()!=null && issue.getStatus().equals("new")){
			issue.setStatus("viewed");
			getCommonService().update(issue);
		}
		List list =getCommonService().getObjects(new Comment(), "comment");
		Collections.sort(list);
		
		mav.addObject("comment",new Comment());
		mav.addObject("comments",list);
		return mav;
	}
	
	@RequestMapping(value="comment",method=RequestMethod.POST)
	public void  doGetComment(HttpServletRequest request,Comment comment,HttpServletResponse response) throws IOException{
		getCommonService().persist(comment);
		response.sendRedirect("/action/issues/detail?issueUuid="+request.getParameter("issueUuid"));
		
	}
	
	@RequestMapping(value="get-person-for-comment",method=RequestMethod.GET)
	public ModelAndView  doGetGetComments(HttpServletRequest request,Comment comment,HttpServletResponse response) throws IOException{
		String email = request.getParameter("email");
		Person person = (Person)getCommonService().getObject(new Person(), email);
		ModelAndView mav =new ModelAndView("/issues/person-for-comment","person",person);
		return mav;
	}
	
	
	
	@RequestMapping(value="change-status",method=RequestMethod.GET)
	public void doGetChangeStatus(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String issueUuid = request.getParameter("issueUuid");
		String status = request.getParameter("status");
		Issue issue = (Issue)getCommonService().getObject(new Issue(), issueUuid);
		issue.setStatus(status);
		getCommonService().update(issue);
		response.sendRedirect("/action/issues/detail?issueUuid="+issueUuid);
	
	}
}
