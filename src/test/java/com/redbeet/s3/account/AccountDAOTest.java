package com.redbeet.s3.account;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.redbeet.s3.MyAbstractTest;

public class AccountDAOTest extends MyAbstractTest {

	@Autowired
	private AccountDAO accountDAO;
	
	@Test
	public void getListTest() throws Exception {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setId("kaya2893");
		List<AccountDTO> ar = accountDAO.getList(accountDTO);
		assertNotEquals(0, ar.size());
	}
	
	@Test
	public void setInsertTest() throws Exception {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccount_num("1233-44-5567883");
		accountDTO.setId("kaya2893");
		accountDTO.setOpen_date(Date.valueOf("2020-03-20"));
		accountDTO.setPassbook_num(4);
		accountDTO.setBalance(100000);
		int result = accountDAO.setInsert(accountDTO);
		
		assertNotEquals(0, result);
	}


}
