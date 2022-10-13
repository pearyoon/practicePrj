package com.kh.appSty07.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.appSty07.member.service.MemberService;
import com.kh.appSty07.member.vo.MemberVo;
@WebServlet(urlPatterns = "/member/login")
public class MemberLoginController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/member/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("memberId");
		String pwd = req.getParameter("memberPwd");
		
		MemberVo vo = new MemberVo();
		
		vo.setId(id);
		vo.setPwd(pwd);
		
		MemberVo loginMember = new MemberService().login(vo);
		
		if(loginMember != null) {
			req.getSession().setAttribute("loginMember", loginMember);
			resp.sendRedirect("/appSty07");
		} else {
			req.setAttribute("errorMsg", "로그인 실패");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
	}
}
