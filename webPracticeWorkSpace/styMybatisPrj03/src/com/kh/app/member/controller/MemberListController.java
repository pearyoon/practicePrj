package com.kh.app.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.common.page.PageVo;
import com.kh.app.common.page.Pagination;
import com.kh.app.member.service.MemberService;
import com.kh.app.member.service.MemberServiceImpl;
import com.kh.app.member.vo.MemberVo;
@WebServlet("/member/list")
public class MemberListController extends HttpServlet{
	private MemberService service = new MemberServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String category = req.getParameter("category");
		String keyword = req.getParameter("keyword");
		
		Map<String, String> map = new HashMap<>();
		map.put("category", category);
		map.put("keyword", keyword);
		
		int p = Integer.parseInt(req.getParameter("p"));
		
		int listCnt = service.selectCount();
		int currentPage = p;
		int boardLimit = 5;
		int pageLimit = 5;
		
		
		PageVo pvo = Pagination.getPageVo(listCnt, currentPage, pageLimit, boardLimit);
		
		List<MemberVo> voList = service.selectMemberList(map, pvo);
		
		req.setAttribute("voList", voList);
		req.getRequestDispatcher("/WEB-INF/views/member/list.jsp").forward(req, resp);
		
	}
}
