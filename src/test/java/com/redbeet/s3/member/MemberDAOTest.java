package com.redbeet.s3.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.redbeet.s3.MyAbstractTest;

public class MemberDAOTest extends MyAbstractTest{

	@Autowired
	private MemberDAO memberDAO;
	
//	@Test
//	public void memberJoinTest() throws Exception {
//		MemberDTO memberDTO = new MemberDTO();
//		memberDTO.setId("mundh123");
//		memberDTO.setPw("Ralala123");
//		memberDTO.setName("Donghyun Moon");
//		memberDTO.setPhone("010-2027-6801");
//		memberDTO.setEmail("mundh123@naver.com");
//		int result = memberDAO.memberJoin(memberDTO);
//		assertEquals(1, result);
//	}
	
//	@Test
//	public void memberLoginTest() throws Exception {
//		MemberDTO memberDTO = new MemberDTO();
//		memberDTO.setId("kaya2893");
//		memberDTO.setPw("kaya6801");
//		memberDTO = memberDAO.memberLogin(memberDTO);
//		assertNotNull(memberDTO.getEmail());
//		
//	}
	
//	@Test
//	public void memberDelete() throws Exception {
//		MemberDTO memberDTO = new MemberDTO();
//		memberDTO.setId("mundh123");
//		memberDTO.setPw("Ralala123");
//		int result = memberDAO.memberDelete(memberDTO);
//		assertEquals(1, result);
//	}
	
//	@Test
//	public void memberUpdate() throws Exception {
//		MemberDTO memberDTO = new MemberDTO();
//		memberDTO.setId("kaya2893");
//		memberDTO.setPw("mun6801");
//		
//		memberDTO = memberDAO.memberLogin(memberDTO);
//		
//		memberDTO.setPw("kaya6801");
//		
//		int result = memberDAO.memberUpdate(memberDTO);
//		assertEquals(1, result);
//	}

	@Test
	public void setFileInsertTest() throws Exception {
		MemberFileDTO mDTO = new MemberFileDTO();
		mDTO.setId("kaya2893");
		mDTO.setFileName("11");
		mDTO.setOriginName("22");
		int result = memberDAO.setFileInsert(mDTO);
		assertNotEquals(0, result);
	}
}
