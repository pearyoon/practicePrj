package com.kh.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.board.service.BoardService;
import com.kh.board.vo.BoardVo;
import com.kh.member.vo.MemberVo;
@WebServlet(urlPatterns = "/board/write")
public class BoardWriteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/board/write.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		HttpSession ss = req.getSession();
		MemberVo loginMem = (MemberVo)ss.getAttribute("loginMem");
		
		String memNo = loginMem.getNo();
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		BoardVo vo = new BoardVo();
		vo.setContent(content);
		vo.setMemNo(memNo);
		vo.setTitle(title);
		
		int result = new BoardService().write(vo);
		
		if(result==1) {
			req.setAttribute("boardVo", vo);
			req.getRequestDispatcher("/board/list").forward(req, resp);
		} else {
			req.setAttribute("msg", "글 작성 실패~");
			req.getRequestDispatcher("/views/common/error.jsp").forward(req, resp);
		}
	}
}
