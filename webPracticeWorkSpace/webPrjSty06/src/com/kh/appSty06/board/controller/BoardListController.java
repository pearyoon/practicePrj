package com.kh.appSty06.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.appSty06.board.service.BoardService;
import com.kh.appSty06.board.vo.BoardVo;
@WebServlet(urlPatterns = "/board/list")
public class BoardListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<BoardVo> voList = new BoardService().selectAllList();
		
		req.setAttribute("voList", voList);
		req.getRequestDispatcher("/views/board/list.jsp").forward(req, resp);

	}
}
