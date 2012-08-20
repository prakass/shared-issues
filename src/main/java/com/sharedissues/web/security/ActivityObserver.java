package com.sharedissues.web.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.sharedissues.entities.Activity;
import com.sharedissues.entities.Issue;
import com.sharedissues.entities.Person;
import com.sharedissues.service.ServiceSupport;

@Service
public class ActivityObserver extends ServiceSupport{
	public void observeActivity(HttpServletRequest request,HttpServletResponse response){
		Activity activity = new Activity();
		String uri = request.getRequestURI();
		Person person = (Person)request.getSession().getAttribute("current.person");
		activity.setWho(person.getEmail());
		if(uri.contains("users/add-user") && request.getMethod().equalsIgnoreCase("post")){
			activity.setWhat("Added new user <b>"+request.getParameter("firstName") + request.getParameter("lastName")+"</b>");
			getCommonService().persist(activity);
		}else if
	    (uri.contains("users/edit-user") && request.getMethod().equalsIgnoreCase("post")){
			activity.setWhat("Updated the informations of <b>"+request.getParameter("firstName") + request.getParameter("lastName")+"</b>");
			getCommonService().persist(activity);
		}else
		if(uri.contains("issues/create") && request.getMethod().equalsIgnoreCase("post")){
			activity.setWhat("Added new task <b>"+request.getParameter("issueTitle")+"</b>");
			getCommonService().persist(activity);
		}else
		if(uri.contains("issues/edit") && request.getMethod().equalsIgnoreCase("post")){
			activity.setWhat("Updated the task <b>" +request.getParameter("issueTitle")+"</b>");
			getCommonService().persist(activity);
		}else
		if(uri.contains("issues/change-status")){
			Issue issue = (Issue)getCommonService().getObject(new Issue(), request.getParameter("issueUuid"));
			String status = request.getParameter("status");
			if(status.equalsIgnoreCase("in-progress")){
				activity.setWhat("Started progress on task <b>" +issue.getIssueTitle()+"</b>");
			}else if(status.equalsIgnoreCase("resolved")){
				activity.setWhat("Resolved task  <b>" +issue.getIssueTitle()+"</b>");
			}else if(status.equalsIgnoreCase("viewed")){
				activity.setWhat("Reopened task <b>" +issue.getIssueTitle()+"</b>");
			}else if(status.equalsIgnoreCase("closed")){
				activity.setWhat("Closed task <b>" +issue.getIssueTitle()+"</b>");
			}else{
				activity.setWhat("Did unknown action on task <b>"+issue.getIssueTitle()+"</b>");
			}
			getCommonService().persist(activity);
		}else
		if(uri.contains("issues/remove")){
			Issue issue = (Issue)getCommonService().getObject(new Issue(), request.getParameter("issueUuid"));
			activity.setWhat("Removed task <b>"+issue.getIssueTitle()+"</b>");
			getCommonService().persist(activity);
		}else 
		if(uri.contains("issues/comment") && request.getMethod().equalsIgnoreCase("post")){
			Issue issue = (Issue)getCommonService().getObject(new Issue(), request.getParameter("issueUuid"));
			activity.setWhat("Commented on task <b>"+issue.getIssueTitle()+"</b>");
			getCommonService().persist(activity);
		}
	}
	
}
