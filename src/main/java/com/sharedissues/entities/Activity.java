package com.sharedissues.entities;

import javax.persistence.*;

import com.sharedissues.all.common.Common;

import java.util.*;


@Entity
@Table(name="activity")
public class Activity implements Comparable<Activity>{
	@Id
	String activityId;
	
	String who;
	
	String what;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date createDate = new Date();
	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public Activity(){this.activityId = Common.getUuid();}

	public String getWho() {
		return who;
	}

	public void setWho(String who) {
		this.who = who;
	}

	public String getWhat() {
		return what;
	}

	public void setWhat(String what) {
		this.what = what;
	}
	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public int compareTo(Activity activity) {
		Activity act = (Activity)activity;
		return act.getCreateDate().compareTo(this.getCreateDate());
	}

	
	
}
