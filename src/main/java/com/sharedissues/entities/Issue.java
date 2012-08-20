package com.sharedissues.entities;

import java.util.Date;

import javax.persistence.*;

import com.sharedissues.all.common.Common;
@Entity
@Table(name="issue")
public class Issue {
	@Id
	@Column(name="issue_uuid")
	String issueUuid;
	
	
	@Column(name="issue_title")
	String issueTitle;
	
	@Column(name="issue_description")
	@Lob
	String issueDescription;
	
	@Column(name="issue_stragety")
	@Lob
	String strategy;

	//Status many contain only 5 values (new,viewed,in-progress,resolved,closed)
	
	@Column(name="issue_status")
	String status;
	
	@Column(name="creator_person_email")
	String creatorPersonEmail;
	
	@Column(name="assigned_person_email")
	String assignedPersonEmail;
	
	String priority;
	
	String category;
	
	public Issue(){this.issueUuid=Common.getUuid();this.status="new";}
	
	@Temporal(TemporalType.DATE)
	Date deadline;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date createDate = new Date();
	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public String getIssueUuid() {
		return issueUuid;
	}

	public void setIssueUuid(String issueUuid) {
		this.issueUuid = issueUuid;
	}

	public String getIssueTitle() {
		return issueTitle;
	}

	public void setIssueTitle(String issueTitle) {
		this.issueTitle = issueTitle;
	}

	public String getIssueDescription() {
		return issueDescription;
	}

	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatorPersonEmail() {
		return creatorPersonEmail;
	}

	public void setCreatorPersonEmail(String creatorPersonEmail) {
		this.creatorPersonEmail = creatorPersonEmail;
	}

	public String getAssignedPersonEmail() {
		return assignedPersonEmail;
	}

	public void setAssignedPersonEmail(String assignedPersonEmail) {
		this.assignedPersonEmail = assignedPersonEmail;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}
	
	
	
	
	
	
	
}
