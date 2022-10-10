package com.kh.board.vo;

public class BoardVo {
	public BoardVo(){
		
	}
	
	public BoardVo(String no, String memNo, String writerNick, String title, String content) {

		this.no = no;
		this.memNo = memNo;
		this.title = title;
		this.content = content;
	}

	private String no;
	private String memNo;

	private String title;
	private String content;
	
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getMemNo() {
		return memNo;
	}

	public void setMemNo(String memNo) {
		this.memNo = memNo;
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

	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", memNo=" + memNo + ", writerNick=" +  ", title=" + title
				+ ", content=" + content + "]";
	}
	
	
}
