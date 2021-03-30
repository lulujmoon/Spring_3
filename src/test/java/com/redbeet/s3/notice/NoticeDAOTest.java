package com.redbeet.s3.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.redbeet.s3.MyAbstractTest;
import com.redbeet.s3.util.Pager;

public class NoticeDAOTest extends MyAbstractTest {

	@Autowired
	private NoticeDAO noticeDAO;

	
	 @Test public void getListTest() throws Exception {
		 Pager pager = new Pager();
		 pager.setStartRow(1);
		 pager.setLastRow(10);
		 List<NoticeDTO> li = noticeDAO.getList(pager); 
		 assertNotEquals(0, li.size()); 
		 }
	 
//	 @Test public void getSelectTest() throws Exception { 
//		 NoticeDTO noticeDTO = new NoticeDTO(); 
//		 noticeDTO.setNum(1); 
//		 noticeDTO = noticeDAO.getSelect(noticeDTO); 
//		 assertNotNull(noticeDTO); 
//		 }
	 

//	@Test public void setInsertTest() throws Exception {
//		int result = 0;
//		for(int i=0;i<120;i++) {
//			NoticeDTO noticeDTO = new NoticeDTO(); 
//			noticeDTO.setSubject("제목"+i); 
//			noticeDTO.setName("관리자");
//			noticeDTO.setContent("내용"+i+"입니다.");
//			result = noticeDAO.setInsert(noticeDTO);
//			if(i%10==0) {
//				Thread.sleep(500);
//			}
//
//		}
//
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
