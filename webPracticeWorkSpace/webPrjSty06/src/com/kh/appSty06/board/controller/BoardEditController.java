package com.kh.appSty06.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.appSty06.board.service.BoardService;
import com.kh.appSty06.board.vo.BoardVo;
@WebServlet(urlPatterns = "/board/edit")
public class BoardEditController extends HttpServlet{
	private final BoardService bs = new BoardService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String no = req.getParameter("no");
		boolean isEdit = true;
		BoardVo vo = bs.selectOne(no, isEdit);
		

		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/views/board/edit.jsp").forward(req, resp);

	}
}
