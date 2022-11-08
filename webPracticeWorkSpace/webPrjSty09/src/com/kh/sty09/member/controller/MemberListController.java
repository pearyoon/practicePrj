package com.kh.sty09.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sty09.member.service.MemberService;
import com.kh.sty09.member.vo.MemberVo;
@WebServlet(urlPatterns = "/admin/member/list")
public class MemberListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<MemberVo> voList = new MemberService().selectList();
		
		
		
		req.setAttribute("voList",voList);
		req.getRequestDispatcher("/WEB-INF/views/member/list.jsp").forward(req, resp);
	}
}
