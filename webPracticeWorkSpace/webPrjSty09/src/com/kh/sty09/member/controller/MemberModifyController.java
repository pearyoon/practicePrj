package com.kh.sty09.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.sty09.member.service.MemberService;
import com.kh.sty09.member.vo.MemberVo;
@WebServlet(urlPatterns = "/login/modify")
public class MemberModifyController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/modify.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ss = req.getSession();
		MemberVo loginMem = (MemberVo)ss.getAttribute("loginMember");
		
		String no = loginMem.getNo();
		String pwd = req.getParameter("userPwd1");
		String name = req.getParameter("userName");
		
		if(pwd == "") {
			pwd = loginMem.getPwd();
		}
		
		
		MemberVo vo  = new MemberVo();
		
		vo.setNo(no);
		vo.setPwd(pwd);
		vo.setName(name);
		

		
		MemberVo updateMember = new MemberService().modify(vo);
		
		if(updateMember != null) {
			ss.setAttribute("loginMember", updateMember);
			resp.sendRedirect("/sty09/login/modify");
		} else {
			req.setAttribute("errorMsg", "회원정보수정실패");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp");
		}
	}
}
