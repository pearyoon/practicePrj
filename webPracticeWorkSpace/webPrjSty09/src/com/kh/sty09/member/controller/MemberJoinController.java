package com.kh.sty09.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sty09.member.service.MemberService;
import com.kh.sty09.member.vo.MemberVo;
@WebServlet(urlPatterns = "/member/join")
public class MemberJoinController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("userId");
		String pwd = req.getParameter("userPwd");
		String name = req.getParameter("userName");
		
		MemberVo vo = new MemberVo();
		
		vo.setId(id);
		vo.setPwd(pwd);
		vo.setName(name);
		
		int result = new MemberService().join(vo);
		
		if(result == 1) {
			resp.sendRedirect("/sty09/member/login");
		} else {
			req.setAttribute("errorMsg", "회원가입 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage").forward(req, resp);
		}
	}
}
