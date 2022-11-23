package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.service.MemberServiceImpl;
import com.kh.app.member.vo.MemberVo;
@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet{
	
	private MemberService ms = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		MemberVo vo = new MemberVo();
		vo.setMemberId(id);
		vo.setMemberPwd(pwd);
	
	
		MemberVo loginMember = ms.login(vo);
		
		System.out.println(loginMember);
		if(loginMember != null) {
			req.getSession().setAttribute("loginMember", loginMember);
			resp.sendRedirect("/mb03");
		} else {
			req.setAttribute("msg", "로그인실패");
			req.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(req, resp);
		}
		
		
		
	}
}
