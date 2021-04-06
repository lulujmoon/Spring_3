package com.redbeet.s3.util;

public class Pager {
	/*
	 * 목적
	 * 1. DB에서 일정한 수만큼 조회
	 * 2. jsp 페이지에 일정한 수만큼 curPage 번호 출력
	 */
	
	//1. 조회 단위 설정
	private long perPage;
	private long perBlock;
	
	public Pager() {
		this.perPage = 10;
		this.perBlock = 5;
		this.curPage = 1;
	}
	
	private long curPage;
	
	//2. rownum 계산
	private long startRow;
	private long lastRow;
	
	public void makeRow() {
		this.startRow = (curPage-1)*perPage+1;
		this.lastRow = curPage*perPage;
	}
	
	private long totalPage;
	private long startNum;
	private long lastNum;
	private boolean pre;
	private boolean next;
	
	//3. paging 계산
	public void paging(long totalCount) {
		//1) 전체 글의 수로 전체 페이지 수 계산
		this.totalPage = totalCount/perPage;
		if(totalCount%perPage!=0) {
			totalPage++;
		}
		
		//2) 전체 블록 수 계산
		long totalBlock = this.totalPage/this.perBlock;
		if(this.totalPage%this.perBlock!=0) {
			totalBlock++;
		}
		
		//3) curPage를 이용해서 curBlock 구하기
		long curBlock = this.curPage/this.perBlock;
		if(this.curPage%this.perBlock!=0) {
			curBlock++;
		}
		
		//4) curBlock으로 startNum, lastNum 구하기
		this.startNum = (curBlock-1)*this.perBlock+1;
		this.lastNum = curBlock*this.perBlock;
		if(curBlock==totalBlock) {
			this.lastNum = this.totalPage;
		}
		
		//5) pre, next
		if(curBlock > 1) {
			this.pre = true;
		}
		
		if(curBlock!=totalBlock) {
			this.next = true;
		}
		
	}

	//setter, getter 준비
	public long getPerPage() {
		return perPage;
	}

	public void setPerPage(long perPage) {
		this.perPage = perPage;
	}

	public long getPerBlock() {
		return perBlock;
	}

	public void setPerBlock(long perBlock) {
		this.perBlock = perBlock;
	}

	public long getCurPage() {
		return curPage;
	}

	public void setCurPage(long curPage) {
		this.curPage = curPage;
	}

	public long getStartRow() {
		return startRow;
	}

	public void setStartRow(long startRow) {
		this.startRow = startRow;
	}

	public long getLastRow() {
		return lastRow;
	}

	public void setLastRow(long lastRow) {
		this.lastRow = lastRow;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public long getStartNum() {
		return startNum;
	}

	public void setStartNum(long startNum) {
		this.startNum = startNum;
	}

	public long getLastNum() {
		return lastNum;
	}

	public void setLastNum(long lastNum) {
		this.lastNum = lastNum;
	}

	public boolean isPre() {
		return pre;
	}

	public void setPre(boolean pre) {
		this.pre = pre;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}
	
	private String type;
	private String search;
	
	
	//검색 기능
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSearch() {
		if(this.search == null) {
			this.search="";
		}
		return search;
	}
	public void setSearch(String search) {
		if(search==null) {
			search="";
		}
		
		this.search = search;
	}
	
}
