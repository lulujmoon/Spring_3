package com.redbeet.s3.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	public String save(String name, MultipartFile multipartFile, HttpSession session) throws Exception {
		//1. 경로 설정
		String path = session.getServletContext().getRealPath("resources/upload/"+name);
		System.out.println(path);
		
		
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//2. 저장할 파일명
		String fileName="";
		
		/*
		 * Calendar 이용할 수도 있다.
		 * Calendar ca = Calendar.getInstance(); 
		 * long time = ca.getTimeInMillis();
		 * fileName=time +"_"+ multipartFile.getOriginalFilename();
		 */
		
		fileName = UUID.randomUUID().toString()+"_"+multipartFile.getOriginalFilename();
		
		//3. HDD에 저장
		
		file = new File(file, fileName);
		/* 첫번째 방법
		 * FileCopyUtils.copy(multipartFile.getBytes(), file); */
		
		multipartFile.transferTo(file);
		
		return fileName;
	}
	
	
	public boolean delete(String name, String fileName, HttpSession session) throws Exception {
		//1. 경로 설정
		String path = session.getServletContext().getRealPath("resources/upload/"+name);
		File file = new File(path, fileName);
		boolean check = false;
		if(file.exists()) {
			check = file.delete();
		}
		return check;
	}

}
