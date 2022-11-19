package com.kh.app.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
@WebServlet("/board/list")
public class BoardListController extends HttpServlet{
	private static final BoardService bs = new BoardService(); 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String category = req.getParameter("category");
		String search = req.getParameter("search");
		
		Map<String,String> searchMap = new HashMap<>();
		
		searchMap.put("category", category);
		searchMap.put("search", search);
		
		List<BoardVo> voList = bs.selectListAll(searchMap);
		
		req.setAttribute("voList", voList);
		req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
	}
}
