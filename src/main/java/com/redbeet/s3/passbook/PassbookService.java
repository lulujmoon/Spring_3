package com.redbeet.s3.passbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redbeet.s3.util.Pager;

@Service
public class PassbookService {
	
	@Autowired
	private PassbookDAO passbookDAO;
	
	public List<PassbookDTO> getList(Pager pager) throws Exception {
		int perPage = 20;
		int perBlock = 10;
		
		long startRow = (pager.getCurPage()-1)*perPage+1;
		long lastRow = pager.getCurPage()*perPage;
		
		long totalCount = passbookDAO.getTotalCount(pager);
		
		long totalPage = totalCount/perPage;
		if(totalCount%perPage!=0) {
			totalPage++;
		}
		
		long totalBlock = totalPage/perBlock;
		if(totalPage%perBlock!=0) {
			totalBlock++;
		}
		

		long curBlock = pager.getCurPage()/perBlock;
		if(pager.getCurPage()%perBlock!=0) {
			curBlock++;
		}
		
		long startNum = (curBlock-1)*perBlock+1;
		long lastNum = curBlock*perBlock;
		
		if(curBlock==totalBlock) {
			lastNum=totalPage;
		}else {
			pager.setNext(true);
		}
		
		if(curBlock!=1) {
			pager.setPre(true);
		}
		
		pager.setStartRow(startRow);
		pager.setLastRow(lastRow);
		pager.setStartNum(startNum);
		pager.setLastNum(lastNum);
		
		return passbookDAO.getList(pager);
	}
	
	public PassbookDTO getSelect(PassbookDTO passbookDTO) throws Exception {
		return passbookDAO.getSelect(passbookDTO);
	}
	
	public int setDelete(PassbookDTO passbookDTO) throws Exception {
		return passbookDAO.setDelete(passbookDTO);
	}
	
	public int setUpdate(PassbookDTO passbookDTO) throws Exception {
		return passbookDAO.setUpdate(passbookDTO);
	}

}
