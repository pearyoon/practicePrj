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
public class BoardLIstController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String category = req.getParameter("category");
		String keyword = req.getParameter("keyword");
		
		Map<String,String> searchMap = new HashMap<>();
		searchMap.put("keyword", keyword);
		searchMap.put("category", category);
		
		List<BoardVo> voList = new BoardService().selsectList(searchMap);
		
		if(voList != null) {
			req.setAttribute("voList", voList);
			req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
		}else {
			req.setAttribute("errorMsg", "게시글 조회 실패");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
