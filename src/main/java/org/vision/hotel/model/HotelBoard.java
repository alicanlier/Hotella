package org.vision.hotel.model;

import java.sql.Date;

public class HotelBoard {
	private int num;
	private String writer;
	//private String email;
	private String subject;
	//private String password;
	private Date reg_date;
	private int ref;// 게시글그룹 
	private int re_step;// 게시순서 
	private int re_level;// 들여쓰기레벨 
	private int readcount;// 히트수 
	private String content;// 게시글내용 
	
	public HotelBoard() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public HotelBoard(int num, String writer, String subject, Date reg_date, int ref, int re_step, int re_level,
			String content) {
		super();
		this.num = num;
		this.writer = writer;
		this.subject = subject;
		this.reg_date = reg_date;
		this.ref = ref;
		this.re_step = re_step;
		this.re_level = re_level;
		this.content = content;
	}
	
	public HotelBoard(int num, String writer, String subject, Date reg_date, int ref, int re_step, int re_level,
			int readcount, String content) {
		super();
		this.num = num;
		this.writer = writer;
		this.subject = subject;
		this.reg_date = reg_date;
		this.ref = ref;
		this.re_step = re_step;
		this.re_level = re_level;
		this.readcount = readcount;
		this.content = content;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRe_step() {
		return re_step;
	}
	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}
	public int getRe_level() {
		return re_level;
	}
	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "HotelBoard [num=" + num + ", writer=" + writer + ", subject=" + subject + ", reg_date=" + reg_date
				+ ", ref=" + ref + ", re_step=" + re_step + ", re_level=" + re_level + ", readcount=" + readcount
				+ ", content=" + content + "]";
	}
	
	
}
