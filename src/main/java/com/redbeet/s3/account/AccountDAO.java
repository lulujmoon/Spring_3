package com.redbeet.s3.account;

import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE= "com.redbeet.s3.account.AccountDAO.";
	
	public int setInsert(AccountDTO accountDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setInsert", accountDTO);
	}
	
	public List<AccountDTO> getList(AccountDTO accountDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList", accountDTO);
	}

}
