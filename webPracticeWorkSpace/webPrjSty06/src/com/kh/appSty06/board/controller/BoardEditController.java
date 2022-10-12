package com.kh.appSty06.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String no = req.getParameter("no");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		BoardVo vo = new BoardVo();
		
		vo.setContent(content);
		vo.setTitle(title);
		vo.setNo(no);
		
		int result = new BoardService().edit(vo);
		
		if(result == 1) {
			req.getSession().setAttribute("alertMsg","수정되었습니다.");
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/views/board/detail.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "에러");
			req.getRequestDispatcher("views/common/error.jsp").forward(req, resp);
		}
		
	}
}
