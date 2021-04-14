package com.redbeet.s3.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.redbeet.s3.board.BoardDTO;
import com.redbeet.s3.board.BoardFileDTO;
import com.redbeet.s3.board.BoardService;
import com.redbeet.s3.util.FileManager;
import com.redbeet.s3.util.OldPager;
import com.redbeet.s3.util.Pager;

@Service
public class NoticeService implements BoardService{

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Autowired
	private HttpSession session;
	
	public String setSummerFileUpload(MultipartFile file) throws Exception {
	 String fileName = fileManager.save("notice", file, session);
	 return fileName;
	}
	
	public boolean setSummerfileDelete(String fileName) throws Exception {
		boolean result = fileManager.delete("notice", fileName, session);
		return result;
	}
	
	
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
	public int setUpdate(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		int result = noticeDAO.setUpdate(boardDTO);
		
		for(MultipartFile mf:files) {
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			String fileName = fileManager.save("notice", mf, session);
			
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriginName(mf.getOriginalFilename());
			boardFileDTO.setNum(boardDTO.getNum());
			
			result = noticeDAO.setFileInsert(boardFileDTO);
		}
		
		return result;
	}

	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		
		long num = noticeDAO.getNum();
		boardDTO.setNum(num);
		int result = noticeDAO.setInsert(boardDTO);
		
		
		for(MultipartFile mf : files) {
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			String fileName = fileManager.save("notice", mf, session);
			
			boardFileDTO.setNum(num);
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriginName(mf.getOriginalFilename());
			
			result = noticeDAO.setFileInsert(boardFileDTO);
		}
		return result;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setDelete(boardDTO);
	}
	
	public int setFileDelete(BoardFileDTO boardFileDTO) throws Exception {
		//1. 조회
		boardFileDTO = noticeDAO.getFileSelect(boardFileDTO);
		
		//2. table에서 삭제
		int result = noticeDAO.setFileDelete(boardFileDTO);
		//3. HDD에서 삭제
		if(result>0) {
			fileManager.delete("notice", boardFileDTO.getFileName(), session);
			result=1;
		}
		return result;
	}
	
	
}
