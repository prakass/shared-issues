package com.sharedissues.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sharedissues.entities.Image;
import com.sharedissues.service.ServiceSupport;

@Controller
@RequestMapping("files")
public class FileController extends ServiceSupport{
	@RequestMapping("all-files")
	public ModelAndView doGetAllFiles(){
		Image image = new Image();
		List<Object> files=getCommonService().getObjects(image, "image");
		ModelAndView mav =new ModelAndView("/files/all-files","files",files);
		return mav;
	}
}
