package com.sharedissues.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.sharedissues.all.common.Common;
import com.sharedissues.all.common.WebUtility;
import com.sharedissues.entities.*;
import com.sharedissues.service.ServiceSupport;

@RequestMapping("/image")
@Controller
public class ImageController extends ServiceSupport{
	@Autowired
	WebUtility webUtility;
	
	
	@RequestMapping("get/{imageUuid}")
	public String getImageByImageId(@PathVariable("imageUuid")String imageUuid,HttpServletResponse response)throws Exception
	{
		Image i =new Image();
		Image image = (Image)getCommonService().getObject(i, imageUuid);
		response.setContentType(image.getFileType());
		response.getOutputStream().write(image.getFileContent());
		int length = image.getFileContent().length;
		response.setContentLength(length);
		response.setHeader("Cache-control", "public, max-age= 10000");
		response.setHeader("Pragma", "Cache-control:public,max-age=10000");
		return null;
	}
	
	
	@RequestMapping(value="upload",method=RequestMethod.POST)
	public String uploadImage(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Image image =new Image();
		String imageUuid = Common.getUuid();
		MultipartHttpServletRequest multiPartRequest =(MultipartHttpServletRequest)request;
		MultipartFile file =multiPartRequest.getFile("image");
		
		if(file.getBytes().length <1000){
			return null;
		}
		String externalUuid =request.getParameter("externalUuid");
		String externalFlag = request.getParameter("externalFlag");
		image.setExternalUuid(externalUuid);
		image.setFileName(file.getName());
		image.setExternalFlag(externalFlag);
		image.setFileType(file.getContentType());
		
		image.setImageUuid(imageUuid);
		image.setFileContent(file.getBytes());
		getCommonService().persist(image);
		webUtility.addServerSuccessMessage(request, "Your profile picture has been uploaded");
		response.sendRedirect(request.getParameter("target")+"?imageUuid="+imageUuid);
		return null;
	}
	
	
	@RequestMapping(value="detail",method=RequestMethod.GET)
	public ModelAndView getImageDetails() {
		ModelAndView mav = new ModelAndView("/common/image/image-detail");
		return mav;
	}
	
	@RequestMapping("all-images")
	public ModelAndView doGetAllFiles(){
		Image image = new Image();
		List<Object> images=getCommonService().getObjects(image, "image");
		ModelAndView mav =new ModelAndView("/images/all-images","images",images);
		return mav;
	}
	
	@RequestMapping("remove")
	public void doGetAllFiles(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String imageUuid = request.getParameter("imageUuid");
		Image image = new Image();
		Object object=getCommonService().getObject(image,imageUuid);
		getCommonService().remove("image","image_uuid", imageUuid);
		response.sendRedirect(request.getParameter("target"));
	}
	
}
