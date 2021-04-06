package com.redbeet.s3.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redbeet.s3.board.BoardDTO;
import com.redbeet.s3.board.BoardService;
import com.redbeet.s3.util.OldPager;
import com.redbeet.s3.util.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaDAO qnaDAO;

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		pager.makeRow();
		
		long totalCount = qnaDAO.getTotalCount(pager);
		pager.paging(totalCount);
		 
		return qnaDAO.getList(pager);
	}

	@Override
	public long getTotalCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getTotalCount(pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		boardDTO =  qnaDAO.getSelect(boardDTO);
		int update = qnaDAO.setHitUpdate(boardDTO);
		return boardDTO;
	}



	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.setUpdate(boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.setInsert(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.setDelete(boardDTO);
	}
	
	public int setReply(QnaDTO qnaDTO) throws Exception {
		//부모글의 ref, step, depth 조회
		QnaDTO parent = (QnaDTO)(qnaDAO.getSelect(qnaDTO));
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep()+1);
		qnaDTO.setDepth(parent.getDepth()+1);
		
		int result = qnaDAO.setReplyUpdate(parent);
		result = qnaDAO.setReply(qnaDTO);
		
		return result;
	}
}
