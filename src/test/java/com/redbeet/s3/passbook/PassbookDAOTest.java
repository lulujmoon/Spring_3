package com.redbeet.s3.passbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.redbeet.s3.MyAbstractTest;

public class PassbookDAOTest extends MyAbstractTest {

	@Autowired
	private PassbookDAO passbookDAO;
	
//	@Test
//	public void setWriteTest() throws Exception {
//		PassbookDTO passbookDTO = new PassbookDTO();
//		passbookDTO.setName("Test");
//		passbookDTO.setIrate(0.12);
//		passbookDTO.setOpenable("Y");
//		int result = passbookDAO.setWrite(passbookDTO);
//		
//		assertEquals(1, result);
//	}
//
	@Test
	public void getSelectTest() throws Exception {
		PassbookDTO passbookDTO = new PassbookDTO();
		passbookDTO.setNum(1);
		passbookDTO = passbookDAO.getSelect(passbookDTO);
		assertNotNull(passbookDTO);
		
		
	}
	
//	@Test
//	public void getListTest() throws Exception {
//		List<PassbookDTO> ar = passbookDAO.getList();
//		assertNotEquals(0, ar.size());
//	}
//	
//	@Test
//	public void setDeleteTest() throws Exception {
//		PassbookDTO passbookDTO = new PassbookDTO();
//		passbookDTO.setNum(6);
//		int result = passbookDAO.setDelete(passbookDTO);
//		
//		assertEquals(1, result);
//	}
	
	@Test
	public void setUpdateTest() throws Exception{
		PassbookDTO passbookDTO = new PassbookDTO();
		passbookDTO.setNum(5);
		
		passbookDTO = passbookDAO.getSelect(passbookDTO);
		
		passbookDTO.setIrate(2.5);
		int result = passbookDAO.setUpdate(passbookDTO);
	}
}
