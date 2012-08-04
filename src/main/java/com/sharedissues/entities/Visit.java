package com.sharedissues.entities;

import javax.persistence.*;

import com.sharedissues.all.common.Common;

@Table(name="visit")
@Entity
public class Visit {
	@Id
	String visitId;
	
	String ipAddress;
	
	String url;
	
	public Visit(){this.visitId =Common.getUuid();}

	public String getVisitId() {
		return visitId;
	}

	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	

}
