package com.sharedissues.web.controller;

import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("index")
	public String doGetIndex(HttpServletRequest request)
	{
		return "/issues/index";
	}
	
	
}
