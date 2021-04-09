package com.redbeet.s3.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.redbeet.s3.util.OldPager;
import com.redbeet.s3.util.Pager;

public interface BoardService {

	
	//list
	public abstract List<BoardDTO> getList(Pager pager) throws Exception;
	
	//전체 글의 수
	public long getTotalCount(Pager pager) throws Exception;
	
	//글 조회
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception;
	
	//조회수 업데이트
	
	//글 수정
	public int setUpdate(BoardDTO boardDTO) throws Exception;
	
	//글 추가
	public int setInsert(BoardDTO boardDTO, MultipartFile [] files) throws Exception;
	
	//글 삭제
	public int setDelete(BoardDTO boardDTO) throws Exception;
}
