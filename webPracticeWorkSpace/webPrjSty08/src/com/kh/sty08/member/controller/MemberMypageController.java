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
@WebServlet(urlPatterns = "/member/mypage")
public class MemberMypageController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ss = req.getSession();
		MemberVo loginMember = (MemberVo)ss.getAttribute("loginMember");
		
		if(loginMember == null) {
			req.setAttribute("errorMsg", "로그인 후 이용해주세요.");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
			
			return;
		}
		
		req.getRequestDispatcher("/views/member/mypage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		HttpSession ss = req.getSession();
		MemberVo loginMember = (MemberVo)ss.getAttribute("loginMember");
		
		String no = loginMember.getNo();
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd1");
		String nick = req.getParameter("nick");
		String phone = req.getParameter("phone");
		String addr = req.getParameter("addr");
		
		MemberVo vo = new MemberVo();
		
		vo.setNo(no);
		vo.setId(id);
		vo.setPwd(pwd);
		vo.setNick(nick);
		vo.setPhone(phone);
		vo.setAddr(addr);
		
		MemberVo updateMember = new MemberService().edit(vo);
		
		if(updateMember != null) {
			ss.setAttribute("alertMsg", "수정 성공");
			ss.setAttribute("loginMember", updateMember);
			resp.sendRedirect("/sty08/member/mypage");
		} else {
			req.setAttribute("errorMsg", "정보 수정 실패");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
	}
}
