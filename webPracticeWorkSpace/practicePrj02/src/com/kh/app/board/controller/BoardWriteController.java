package com.kh.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/board/write.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		BoardVo vo = new BoardVo();
		vo.setContent(content);
		vo.setTitle(title);
		
		int result = new BoardService().write(vo);
		
		if(result == 1) {
			resp.sendRedirect("/prj02/board/list");
		} else {
			req.setAttribute("errorMsg", "작성 실패ㅠ");
			req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
		}
		
		
	}
}
