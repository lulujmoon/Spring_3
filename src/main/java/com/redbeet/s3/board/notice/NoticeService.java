package com.redbeet.s3.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redbeet.s3.board.BoardDTO;
import com.redbeet.s3.board.BoardService;
import com.redbeet.s3.util.OldPager;
import com.redbeet.s3.util.Pager;

@Service
public class NoticeService implements BoardService{

	@Autowired
	private NoticeDAO noticeDAO;
	
	public List<BoardDTO> getList(Pager pager) throws Exception {
				
		pager.makeRow();
		long totalCount = noticeDAO.getTotalCount(pager);
		pager.paging(totalCount);
		
		return noticeDAO.getList(pager);
	}

	@Override
	public long getTotalCount(Pager pager) throws Exception {
		return noticeDAO.getTotalCount(pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		boardDTO =  noticeDAO.getSelect(boardDTO);
		int update = noticeDAO.setHitUpdate(boardDTO);
		return boardDTO;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setInsert(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setDelete(boardDTO);
	}
	
	
}
