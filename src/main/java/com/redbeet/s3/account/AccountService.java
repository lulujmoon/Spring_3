package com.redbeet.s3.account;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	@Autowired
	private AccountDAO accountDAO;
	
	public List<AccountDTO> getList(AccountDTO accountDTO) throws Exception {
		List<AccountDTO> ar = accountDAO.getList(accountDTO);
		return ar;
	}
	
	public int setInsert(AccountDTO accountDTO) throws Exception {
		Calendar ca = Calendar.getInstance();
		long time = ca.getTimeInMillis();
		
		String t = time+"";
		//t=String.valueOf(time);도 가능
		
		String result = t.substring(0, 4)+"-";
		result = result + t.substring(4, 8) +"-";
		result = result + t.substring(8);
		
		accountDTO.setAccount_num(result);
		
		return accountDAO.setInsert(accountDTO);
	}
}
