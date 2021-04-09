package com.redbeet.s3.member;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.redbeet.s3.MyAbstractTest;

public class MemberDAOTest extends MyAbstractTest{

	@Autowired
	MemberDAO memberDAO = new MemberDAO();
	
	@Test
	public void setFileInsertTest() throws Exception {
		
	}
	
}
