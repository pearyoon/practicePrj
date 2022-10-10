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
		String id = req.getParameter("memberId");
		String pwd = req.getParameter("memberPwd1");
		String nick = req.getParameter("memberNick");
		String addr = req.getParameter("addr");
		String[] hobby = req.getParameterValues("hobby");
		
		MemberVo vo = new MemberVo();
		vo.setId(id);
		vo.setPwd(pwd);
		vo.setNick(nick);
		vo.setAddr(addr);
		vo.setHobby(String.join(",", hobby));
		
		int result = new MemberService().join(vo);
		
		if(result == 1) {
			HttpSession ss = req.getSession();
			ss.setAttribute("alertMsg", "회원가입 성공!");
			resp.sendRedirect("/appSty06/member/login");
		} else {
			req.setAttribute("msg", "회원가입을 실패하였습니다.");
			req.getRequestDispatcher("/views/common/error.jsp").forward(req, resp);
		}
		
	}
}
