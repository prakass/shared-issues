package com.sharedissues.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.sharedissues.entities.Comment;
import com.sharedissues.entities.Issue;
import com.sharedissues.entities.Person;
import com.sharedissues.service.ServiceSupport;

@Controller
@RequestMapping("issues")
public class IssueController extends ServiceSupport{
	
	@RequestMapping(value="index",method=RequestMethod.GET)
	public ModelAndView doGetDashBoard(){
		ModelAndView mav =new ModelAndView("/issues/index","issues",getCommonService().getObjects(new Issue(), "issue"));
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
		response.sendRedirect(request.getRequestURI());
	}
	
	@RequestMapping(value="edit",method=RequestMethod.GET)
	public ModelAndView doGetEditIssue(HttpServletResponse response, HttpServletRequest request){
		ModelAndView mav =new ModelAndView("/issues/edit","issue",getCommonService().getObject(new Issue(), request.getParameter("issueUuid")));
		mav.addObject("persons", getCommonService().getObjects(new Person(), "person"));
		return mav;
	}
	
	@RequestMapping(value="edit",method=RequestMethod.POST)
	public void doPostEditIssue(Issue issue,HttpServletResponse response) throws IOException{
		getCommonService().update(issue);
		response.sendRedirect("/action/issues/detail?issueUuid="+issue.getIssueUuid());
		
	}
	
	
	@RequestMapping(value="remove",method=RequestMethod.POST)
	public ModelAndView doGetDeleteIssue(){
		return null;
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
		if(issue.getStatus()==null || issue.getStatus()==""){
			issue.setStatus("viewed");
			getCommonService().update(issue);
		}
		mav.addObject("comment",new Comment());
		mav.addObject("comments",getCommonService().getObjects(new Comment(), "comment"));
		return mav;
	}
	
	@RequestMapping(value="comment",method=RequestMethod.POST)
	public void  doGetComment(HttpServletRequest request,Comment comment,HttpServletResponse response) throws IOException{
		getCommonService().persist(comment);
		response.sendRedirect("/action/issues/detail?issueUuid="+request.getParameter("issueUuid"));
		
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
