package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.service.MemberService;
import com.kh.member.vo.MemberVo;
@WebServlet(urlPatterns = "/member/join")
public class MemberJoinController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/member/join.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("memberId");
		String pwd = req.getParameter("memberPwd1");
		String nick = req.getParameter("memberNick");
		String addr = req.getParameter("addr");
		String[] hobby = req.getParameterValues("hobby");
		
		MemberVo vo = new MemberVo();
		vo.setAddr(addr);
		vo.setHobby(String.join(",",hobby));
		vo.setId(id);
		vo.setPwd(pwd);
		vo.setNick(nick);
		
		int result = new MemberService().join(vo);
		
		if(result==1) {
			resp.sendRedirect("/appSty05/member/login");
		} else {
			req.setAttribute("msg", "회원가입 실패");
			req.getRequestDispatcher("/views/common/error.jsp").forward(req, resp);
		}
	}	
}
