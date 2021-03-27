package com.redbeet.s3.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.redbeet.s3.MyAbstractTest;

public class NoticeDAOTest extends MyAbstractTest {

	@Autowired
	private NoticeDAO noticeDAO;

	
//	 @Test public void getListTest() throws Exception { 
//		 List<NoticeDTO> li = noticeDAO.getList(); 
//		 assertNotEquals(0, li.size()); 
//		 }
	 
//	 @Test public void getSelectTest() throws Exception { 
//		 NoticeDTO noticeDTO = new NoticeDTO(); 
//		 noticeDTO.setNum(1); 
//		 noticeDTO = noticeDAO.getSelect(noticeDTO); 
//		 assertNotNull(noticeDTO); 
//		 }
	 

//	@Test public void setInsertTest() throws Exception {
//		NoticeDTO noticeDTO = new NoticeDTO(); 
//		noticeDTO.setSubject("제목4"); 
//		noticeDTO.setName("관리자");
//		noticeDTO.setContent("내용4입니다.");
//	  
//		int result = noticeDAO.setInsert(noticeDTO);
//	 
//		assertNotEquals(0, result); 
//	}
	 

//	@Test
//	public void setUpdateTest() throws Exception {
//		NoticeDTO noticeDTO = new NoticeDTO();
//		noticeDTO.setNum(4);
//		noticeDTO.setSubject("제목3");
//		noticeDTO.setName("관리자");
//		noticeDTO.setContent("내용3입니다.");
//		int result = noticeDAO.setUpdate(noticeDTO);
//		assertNotEquals(0, result);
//	}

//	@Test
//	public void setDeleteTest() throws Exception{
//		NoticeDTO noticeDTO = new NoticeDTO();
//		noticeDTO.setNum(4);
//		int result = noticeDAO.setDelete(noticeDTO);
//		assertNotEquals(0, result);
//	}

//	@Test
//	public void setHitUpdateTest() throws Exception {
//		NoticeDTO noticeDTO = new NoticeDTO();
//		noticeDTO.setNum(3);
//		int result = noticeDAO.setHitUpdate(noticeDTO);
//		assertNotEquals(0, result);
//	}
}
