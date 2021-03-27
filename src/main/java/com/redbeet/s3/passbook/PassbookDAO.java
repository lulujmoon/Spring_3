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
	
	public List<PassbookDTO> getList() throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList");
	}
	
	public int setDelete(PassbookDTO passbookDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setDelete", passbookDTO);
	}
	
	public int setUpdate(PassbookDTO passbookDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setUpdate", passbookDTO);
	}
}