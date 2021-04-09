package com.redbeet.s3.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.redbeet.s3.member.MemberDAO.";
	
	//setFileInsert
	public int setFileInsert(MemberFileDTO memberFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setFileInsert", memberFileDTO);
	}
	
	
	public int memberJoin(MemberDTO memberDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"memberJoin", memberDTO);
		
	}
	
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"memberLogin", memberDTO);
	
	}
	
	public MemberFileDTO memberLoginFile(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"memberLoginFile", memberDTO);
	}
	
	public int memberDelete(MemberDTO memberDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"memberDelete", memberDTO);
	}
	
	public MemberFileDTO getMemberFile(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getMemberFile", memberDTO);
	}
	
	public int memberUpdate(MemberDTO memberDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"memberUpdate", memberDTO);
	}
}
