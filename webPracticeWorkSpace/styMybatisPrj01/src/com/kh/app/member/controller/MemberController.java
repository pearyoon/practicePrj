package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;
@WebServlet("/member/join")
public class MemberController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("userId");
		String pwd = req.getParameter("userPwd");
		
		MemberVo vo = new MemberVo();
		vo.setId(id);
		vo.setPwd(pwd);
		
		MemberService ms = new MemberService();
		int result = ms.join(vo);
		
		if(result==1) {
			req.setAttribute("result", result);
			req.getRequestDispatcher("/WEB-INF/views/member/result.jsp").forward(req, resp);
		}
		
	}
}
