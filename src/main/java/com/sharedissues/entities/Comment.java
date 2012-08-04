package com.sharedissues.entities;

import javax.persistence.*;

import com.sharedissues.all.common.Common;
import java.util.*;
@Entity
@Table(name="comment")
public class Comment {
	@Id
	String commentUuid;
	
	String personEmail;
	
	String comment;
	
	String issueUuid;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date date =new Date();
	
	public Comment(){this.commentUuid = Common.getUuid();}

	public String getCommentUuid() {
		return commentUuid;
	}

	public void setCommentUuid(String commentUuid) {
		this.commentUuid = commentUuid;
	}


	public String getPersonEmail() {
		return personEmail;
	}

	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}

	public String getIssueUuid() {
		return issueUuid;
	}

	public void setIssueUuid(String issueUuid) {
		this.issueUuid = issueUuid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
