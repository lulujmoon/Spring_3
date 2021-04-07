package com.redbeet.s3.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class OldFileManager {


	public File makePath(HttpSession session) throws Exception {
		//1. 저장할 위치 resources/upload/member
		//2. os에서 인식할 수 있는 실제 경로 찾기
		//jsp : application - server : ServletContext
		String path = session.getServletContext().getRealPath("resources/upload/member");
		System.out.println(path);
		//3. 실제 경로에 폴더가 없으면 파일 저장 시 에러 발생
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		return file;
	}
	
	public String makeTimeFileName() throws Exception {
		Calendar ca = Calendar.getInstance();
		long time = ca.getTimeInMillis();
		return String.valueOf(time);
	}
	
	public String makeUUIDFileName() throws Exception {
		return UUID.randomUUID().toString();
	}
	
	public void saveUseCopy(MultipartFile multipartFile, File file) throws Exception {
		FileCopyUtils.copy(multipartFile.getBytes(), file);
	}
	
	public void saveUseTransfer(MultipartFile multipartFile, File file) throws Exception {
		multipartFile.transferTo(file);
	}
	
//	//4. 저장할 파일명 생성
//	//	a. 시간
//	Calendar ca = Calendar.getInstance();
//	long time = ca.getTimeInMillis();
//	
//	String name = avatar.getOriginalFilename();
//	int index = name.lastIndexOf('.');
//	name = name.substring(index);
//	System.out.println("확장자 : "+name);
//	name=time+name;
//
//	name = time+"_"+avatar.getOriginalFilename();
//	System.out.println(name);
//	
//	//b. UUID
//	String fileName = UUID.randomUUID().toString();
//	fileName = fileName+"_"+avatar.getOriginalFilename();
//	System.out.println("UUID : "+fileName);
//	
//	//5. HDD에 파일 저장
//	file = new File(path, fileName);
//	//1) FileCopyUtils 클래스의 copy 메서드 사용
//	//FileCopyUtils.copy(avatar.getBytes(), file);
//	//2) MultipartFile 클래스의 메서드 사용
//	file = new File(file, fileName);
//	avatar.transferTo(file);
}
