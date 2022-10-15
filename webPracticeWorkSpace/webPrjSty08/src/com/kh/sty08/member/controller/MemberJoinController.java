package com.kh.sty08.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.sty08.member.service.MemberService;
import com.kh.sty08.member.vo.MemberVo;
@WebServlet(urlPatterns = "/member/join")
public class MemberJoinController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/views/member/join.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 인코딩
		req.setCharacterEncoding("UTF-8");
		
		// 데이터 꺼내기
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd1");
		String nick = req.getParameter("nick");
		String addr = req.getParameter("addr");
		String phone = req.getParameter("phone");
		
		// 데이터 뭉치기
		MemberVo vo = new MemberVo();
		vo.setAddr(addr);
		vo.setId(id);
		vo.setNick(nick);
		vo.setPhone(phone);
		vo.setPwd(pwd);
		
		int result = new MemberService().join(vo);
		
		if(result == 1) {
			HttpSession ss = req.getSession();
			ss.setAttribute("alertMsg", "회원가입성공");
			
			resp.sendRedirect("/sty08/member/login");
		} else {
			req.setAttribute("msg", "회원가입실패");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
	}
}
