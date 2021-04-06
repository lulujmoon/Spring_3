package com.redbeet.s3.passbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.redbeet.s3.util.OldPager;

@Repository
public class PassbookDAO {

	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.redbeet.s3.passbook.PassbookDAO.";
	
	
	public int setWrite(PassbookDTO passbookDTO) throws Exception {
		int result = sqlSession.insert(NAMESPACE+"setWrite", passbookDTO);
		
		return result;
	}
	
	public PassbookDTO getSelect(PassbookDTO passbookDTO) throws Exception {
		passbookDTO = sqlSession.selectOne(NAMESPACE+"getSelect", passbookDTO);
		return passbookDTO;
	}
	
	public List<PassbookDTO> getList(OldPager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList", pager);
	}
	
	public long getTotalCount(OldPager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getTotalCount", pager);
	}
	
	public int setDelete(PassbookDTO passbookDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setDelete", passbookDTO);
	}
	
	public int setUpdate(PassbookDTO passbookDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setUpdate", passbookDTO);
	}
}