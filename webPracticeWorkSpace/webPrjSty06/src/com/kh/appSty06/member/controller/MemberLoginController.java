package com.kh.appSty06.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.appSty06.member.service.MemberService;
import com.kh.appSty06.member.vo.MemberVo;
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
		
		MemberVo loginMember = new MemberService().selectOne(vo);
		
		if(loginMember != null) {
			HttpSession ss = req.getSession();
			ss.setAttribute("loginMember", loginMember);
			resp.sendRedirect("/appSty06");
			
		}else {
			req.getRequestDispatcher("/viwes/common/error.jsp").forward(req, resp);
		}
	}
}

