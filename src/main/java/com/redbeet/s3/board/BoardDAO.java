package com.redbeet.s3.board;

import java.util.List;

import com.redbeet.s3.util.OldPager;
import com.redbeet.s3.util.Pager;

public interface BoardDAO {

	//상수, 추상메서드
	//접근지정자는 무조건 public, 그외지정자는 무조건 abstract (둘다 생략 가능)
	
	
	//list
	public abstract List<BoardDTO> getList(Pager pager) throws Exception;
	
	//전체 글의 수
	public long getTotalCount(Pager pager) throws Exception;
	
	//글 조회
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception;
	
	//조회수 업데이트
	public int setHitUpdate(BoardDTO boardDTO) throws Exception;
	
	//글 수정
	public int setUpdate(BoardDTO boardDTO) throws Exception;
	
	//글 추가
	public int setInsert(BoardDTO boardDTO) throws Exception;
	
	//글 삭제
	public int setDelete(BoardDTO boardDTO) throws Exception;
	
}
