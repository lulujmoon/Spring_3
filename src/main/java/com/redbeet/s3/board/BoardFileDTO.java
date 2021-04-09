package com.redbeet.s3.board;

public class BoardFileDTO {
	
	private long fileNum;
	private long num;
	private String fileName;
	private String OriginName;
	
	public long getFileNum() {
		return fileNum;
	}
	public void setFileNum(long fileNum) {
		this.fileNum = fileNum;
	}
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getOriginName() {
		return OriginName;
	}
	public void setOriginName(String originName) {
		OriginName = originName;
	}
	
	

}
