package com.kh.appSty06.board.vo;

public class BoardVo {
	public BoardVo() {
		
	}
	
	
	
	public BoardVo(String no, String writer, String title, String content, String hit, String enrollDate,
			String modifyDate, String status) {
		super();
		this.no = no;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}



	private String no;
	private String writer;
	private String title;
	private String content;
	private String hit;
	private String enrollDate;
	private String modifyDate;
	private String status;
	public String getNo() {
		return no;
	}



	public void setNo(String no) {
		this.no = no;
	}



	public String getWriter() {
		return writer;
	}



	public void setWriter(String writer) {
		this.writer = writer;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getHit() {
		return hit;
	}



	public void setHit(String hit) {
		this.hit = hit;
	}



	public String getEnrollDate() {
		return enrollDate;
	}



	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}



	public String getModifyDate() {
		return modifyDate;
	}



	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", writer=" + writer + ", title=" + title + ", content=" + content + ", hit=" + hit
				+ ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", status=" + status + "]";
	}
	
	
}
