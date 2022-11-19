package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;
@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet{
	
	private static MemberService ms = new MemberService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		MemberVo vo = new MemberVo();
		
		vo.setId(id);
		vo.setPwd(pwd);
		
		MemberVo loginMem = ms.selectOne(vo);
		
		if(loginMem != null) {
			req.getSession().setAttribute("loginMem", loginMem);
			
			resp.sendRedirect("/mb02");
		} else {
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
		
	}
}
