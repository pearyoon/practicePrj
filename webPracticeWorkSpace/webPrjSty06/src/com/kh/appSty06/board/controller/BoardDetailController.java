package com.kh.appSty06.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.appSty06.board.service.BoardService;
import com.kh.appSty06.board.vo.BoardVo;
@WebServlet(urlPatterns = "/board/detail")
public class BoardDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean isEdit = false;
		
		String no = req.getParameter("no");
		BoardVo vo = new BoardService().selectOne(no,isEdit);
		
		if(vo != null) {
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/views/board/detail.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "게시글 상세 조회 실패");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);

		}
	}
}
