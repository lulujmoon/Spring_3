package com.redbeet.s3.board.comments;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.redbeet.s3.board.notice.NoticeDTO;

@Repository
public class CommentsDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.redbeet.s3.board.comments.CommentsDAO.";
	
	
	public List<CommentsDTO> getList(CommentsDTO commentsDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList", commentsDTO);
	}
	
	public int setInsert(CommentsDTO commentsDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setInsert", commentsDTO);
	}
	
	public int setDelete(CommentsDTO commentsDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setDelete", commentsDTO);
	}
}
