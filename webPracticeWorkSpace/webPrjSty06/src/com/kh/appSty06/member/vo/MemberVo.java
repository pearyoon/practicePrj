package com.kh.appSty06.member.vo;

public class MemberVo {
	
	public MemberVo() {
		
	}
	

	
	public MemberVo(String no, String id, String pwd, String nick, String addr, String hobby, String enrollDate,
			String modifDate, String status) {
		super();
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.nick = nick;
		this.addr = addr;
		this.hobby = hobby;
		this.enrollDate = enrollDate;
		this.modifDate = modifDate;
		this.status = status;
	}



	private String no;
	private String id;
	private String pwd;
	private String nick;
	private String addr;
	private String hobby;
	private String enrollDate;
	private String modifDate;
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



	public String getHobby() {
		return hobby;
	}



	public void setHobby(String hobby) {
		this.hobby = hobby;
	}



	public String getEnrollDate() {
		return enrollDate;
	}



	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}



	public String getModifDate() {
		return modifDate;
	}



	public void setModifDate(String modifDate) {
		this.modifDate = modifDate;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", id=" + id + ", pwd=" + pwd + ", nick=" + nick + ", addr=" + addr + ", hobby="
				+ hobby + ", enrollDate=" + enrollDate + ", modifDate=" + modifDate + ", status=" + status + "]";
	}



}


