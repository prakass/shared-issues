package com.sharedissues.all.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharedissues.service.CommonService;
import com.sharedissues.service.PersonReadService;
import com.sharedissues.service.PersonWriteService;

@Service
public class MyService
{
	@Autowired
    PersonReadService personReadService;
	@Autowired 
	PersonWriteService personWriteService;
	@Autowired
	CommonService commonService;
	
	public CommonService getCommonService() {
		return commonService;
	}
	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}
	public PersonReadService getPersonReadService() {
		return personReadService;
	}
	public void setPersonReadService(PersonReadService personReadService) {
		this.personReadService = personReadService;
	}
	public PersonWriteService getPersonWriteService() {
		return personWriteService;
	}
	public void setPersonWriteService(PersonWriteService personWriteService) {
		this.personWriteService = personWriteService;
	}
	
	
}
