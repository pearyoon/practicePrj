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
@WebServlet("/member/modify")
public class MemberModifyController extends HttpServlet{
	private MemberService ms = new MemberServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/modify.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String nick = req.getParameter("nick");
		
		MemberVo vo = new MemberVo();
		vo.setMemberId(id);
		vo.setMemberNick(nick);
		vo.setMemberPwd(pwd);
		
		int result = ms.updateMember(vo);
		
		if(result == 1) {
			req.getSession().setAttribute("loginMember", vo);
			req.setAttribute("msg","수정완");
			
		} else {
			req.setAttribute("msg","수정실패");
		}
		req.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(req, resp);
	}
}
