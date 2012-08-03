package com.sharedissues.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.sharedissues.all.common.Queryable;
import com.sharedissues.entities.Person;

@Service
public class PersonReadService extends Queryable {
	
	public List<Object> findPersonByQuery(String query){
		String sql = "select * from person where email like '"+query+"' or user_first_name like '"+query+"' or user_last_name like '"+query+"' or  city like'"+query+"' order by email;";
		Person p =new Person();
		return getObjectsForQuery(sql,p);
	}
	
}
