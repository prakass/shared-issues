package com.sharedissues.all.common;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

public class PasswordEncoder {
	public static String encode(String username,String password){
		ShaPasswordEncoder encoder =new ShaPasswordEncoder(512);
		encoder.setIterations(987);
		return encoder.encodePassword(password, username);
		
	}
}
