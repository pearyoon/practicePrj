package com.kh.sty09.member.vo;

public class MemberVo {
	public MemberVo() {
		
	}
	
	
	
	public MemberVo(String no, String id, String pwd, String name, String enrollDate, String status) {
		super();
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.enrollDate = enrollDate;
		this.status = status;
	}



	private String no;
	private String id;
	private String pwd;
	private String name;
	private String enrollDate;
	private String status;
	public String getNo() {
		return no;
	}



	public void setNo(String no) {
		this.no = no;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPwd() {
		return pwd;
	}



	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEnrollDate() {
		return enrollDate;
	}



	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", enrollDate=" + enrollDate
				+ ", status=" + status + "]";
	}
	

	
	
}
