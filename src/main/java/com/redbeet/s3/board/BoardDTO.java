package com.redbeet.s3.board;

import java.sql.Date;
import java.util.List;

public class BoardDTO {

	private long num;
	private String Subject;
	private String Name;
	private Date regdate;
	private long hit;
	private String Content;
	private List<BoardFileDTO> boardFiles;

	public List<BoardFileDTO> getBoardFiles() {
		return boardFiles;
	}

	public void setBoardFiles(List<BoardFileDTO> boardFiles) {
		this.boardFiles = boardFiles;
	}
	
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		this.Subject = subject;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public long getHit() {
		return hit;
	}
	public void setHit(long hit) {
		this.hit = hit;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		this.Content = content;
	}
	
	
}
