package com.redbeet.s3.util;

public class OldPager {

	private long perPage = 20;
	private long perBlock = 5;
	private long curPage;
	private long startRow;
	private long lastRow;
	
	private long startNum;
	private long lastNum;
	
	private boolean pre;
	private boolean next;
	
	//search용
	private String type;
	private String search;
	
	
	
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

	public long getCurPage() {
		if(this.curPage<1) {
			this.curPage=1;
		}
		return curPage;
	}
	public void setCurPage(long curPage) {
		if(curPage<1) {
			curPage=1;
		}
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
	
	
	public void makeRow() {
		this.setStartRow(perPage*(this.getCurPage()-1)+1);
		this.setLastRow(perPage*this.getCurPage());
	}
	
	public void makeNum(long totalCount) {
		long totalPage = totalCount / perPage;
		if(totalCount%perPage!=0) {
			totalPage++;
		}
		//3. 블록 관련 설정
		long totalBlock = totalPage / perBlock;
		if(totalBlock%perBlock!=0) {
			totalBlock++;
		}else if(totalBlock<perBlock) {
			totalBlock =1;
		}
		
		long curBlock = this.getCurPage() / perBlock;
		if(this.getCurPage()%perBlock!=0) {
			curBlock++;
		}
		
		long startNum = perBlock*(curBlock-1)+1;
		long lastNum = perBlock*curBlock;
		
		if(curBlock==totalBlock) {
			lastNum=totalPage;
		}
		
		//4. pre, next 설정
		boolean pre = false;
		boolean next = false;
		
		if(curBlock!=1) {
			this.setPre(true);
		}
		if(curBlock!=totalBlock) {
			this.setNext(true);
		}
		

		this.setStartNum(startNum);
		this.setLastNum(lastNum);
		this.setPre(next);
		this.setNext(pre);
	}
	
}
