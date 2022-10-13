package com.kh.appSty07.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.appSty07.member.service.MemberService;
import com.kh.appSty07.member.vo.MemberVo;
@WebServlet(urlPatterns = "/member/join")
public class MemberJoinController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/member/join.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("memberId");
		String pwd = req.getParameter("memberPwd");
		String nick = req.getParameter("memberNick");
		
		MemberVo vo = new MemberVo();
		
		vo.setId(id);
		vo.setPwd(pwd);
		vo.setNick(nick);
		
		int result = new MemberService().join(vo);
		
		if(result == 1) {
			req.setAttribute("alretMsg", "회원가입 성공!");
			req.getRequestDispatcher("/").forward(req, resp);
		} else {
			req.setAttribute("errorMsg", "회원가입 실패~");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
	}
}
