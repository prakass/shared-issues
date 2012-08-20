package com.sharedissues.entities;

import javax.persistence.*;

import com.sharedissues.all.common.Common;
import java.util.*;
@Entity
@Table(name="comment")
public class Comment implements Comparable<Comment>{
	@Id
	String commentUuid;
	
	String personEmail;
	
	String personFullName;
	
	String comment;
	
	String personProfilePicture;

	String issueUuid;
	
	
	public int compareTo(Comment comment) {
		Comment cmt = (Comment)comment;
		return this.getDate().compareTo(cmt.getDate());
	}
	
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
	
	public String getPersonFullName() {
		return personFullName;
	}

	public void setPersonFullName(String personFullName) {
		this.personFullName = personFullName;
	}
	
	public String getPersonProfilePicture() {
		return personProfilePicture;
	}

	public void setPersonProfilePicture(String personProfilePicture) {
		this.personProfilePicture = personProfilePicture;
	}

	
	
}
