package com.sharedissues.all.common;

import java.util.UUID;

public class Common {
	public static String getUuid(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
