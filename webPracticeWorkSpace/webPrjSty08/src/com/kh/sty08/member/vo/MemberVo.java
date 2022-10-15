package com.kh.sty08.member.vo;

public class MemberVo {
	public MemberVo() {
		
	}
	
	
	
	public MemberVo(String no, String id, String pwd, String nick, String addr, String phone, String grade,
			String enrollDate, String modifyDate, String status) {
		super();
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.nick = nick;
		this.addr = addr;
		this.phone = phone;
		this.grade = grade;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}



	private String no;
	private String id;
	private String pwd;
	private String nick;
	private String addr;
	private String phone;
	private String grade;
	private String enrollDate;
	private String modifyDate;
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



	public String getNick() {
		return nick;
	}



	public void setNick(String nick) {
		this.nick = nick;
	}



	public String getAddr() {
		return addr;
	}



	public void setAddr(String addr) {
		this.addr = addr;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getGrade() {
		return grade;
	}



	public void setGrade(String grade) {
		this.grade = grade;
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
		return "MemberVo [no=" + no + ", id=" + id + ", pwd=" + pwd + ", nick=" + nick + ", addr=" + addr + ", phone="
				+ phone + ", grade=" + grade + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", status="
				+ status + "]";
	}
	
	
	
	
}
