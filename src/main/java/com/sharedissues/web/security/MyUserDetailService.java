package com.sharedissues.web.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.sharedissues.entities.Person;
import com.sharedissues.service.ServiceSupport;

@Service
public class MyUserDetailService extends ServiceSupport  implements UserDetailsService{
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Person person =new Person();
		Person p  = (Person)getCommonService().getObject(person, username);
		
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		for(String role: p.getRolesAsList()){
			roles.add(new GrantedAuthorityImpl(role));
		}
		return new org.springframework.security.core.userdetails.User(p.getEmail(),p.getPassword(),true, true, true, true, roles);
		
	}
}
