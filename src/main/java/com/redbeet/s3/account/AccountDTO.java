package com.redbeet.s3.account;

import java.sql.Date;

public class AccountDTO {
	
	private String account_num;
	private String id;
	private int passbook_num;
	private Date open_date;
	private long balance;
	
	public String getAccount_num() {
		return account_num;
	}
	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPassbook_num() {
		return passbook_num;
	}
	public void setPassbook_num(int passbook_num) {
		this.passbook_num = passbook_num;
	}
	public Date getOpen_date() {
		return open_date;
	}
	public void setOpen_date(Date open_date) {
		this.open_date = open_date;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	

}
