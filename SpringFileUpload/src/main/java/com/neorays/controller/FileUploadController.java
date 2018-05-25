package com.neorays.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.neorays.command.UploadCommand;




@Controller
public class FileUploadController {

	@RequestMapping(value="/upload.htm",method=RequestMethod.GET)
	public  void showForm(@ModelAttribute("uploadCmd")UploadCommand cmd){
		System.out.println("showForm");
	}
	
	
	@RequestMapping(value="/upload.htm",method=RequestMethod.POST)
	public String processForm(Map<String,Object> map,@ModelAttribute("uploadCmd")UploadCommand cmd)throws Exception{
		System.out.println("processForm");
		String destDir="D:/Uploads";
	 File destDirectory=null;
	 MultipartFile mfile1=null,mfile2=null;
	 InputStream is1=null,is2=null;
	 String fileName1=null,fileName2=null;
	 OutputStream os1=null,os2=null;
	 //create or locate E/Uploads folder
	 destDirectory=new File(destDir);
	 if(!destDirectory.exists())
		 destDirectory.mkdir();
	 //Recieve the uploaded files
	 mfile1=cmd.getFile1();
	 mfile2=cmd.getFile2();
	 System.out.println(1+" "+mfile1+"  "+mfile2);
	 //create InputStreams representing uploaded files
	 is1=mfile1.getInputStream();
	 is2=mfile2.getInputStream();
	 //get orginal uploaded file names
	 fileName1=mfile1.getOriginalFilename();
	 fileName2=mfile2.getOriginalFilename();
	 System.out.println(2);
	 //create OutputStreams pointing to Dest files (names must match with uploaded file names) 
      os1=new FileOutputStream(destDirectory.getAbsolutePath()+"/"+fileName1);
      os2=new FileOutputStream(destDirectory.getAbsolutePath()+"/"+fileName2);
      //write th content of uploaded files to Dest files
      IOUtils.copy(is1, os1);
      IOUtils.copy(is2,os2);
      System.out.println(is1+" "+is2+" "+os1+" "+os2);
      //close streams
      is1.close();
      is2.close();
      os1.close();
      os2.close();
      //add file names to model attribute
      map.put("fileName1", fileName1);
      map.put("fileName2", fileName2);
      return "success_upload";
	}//mehtod
}//