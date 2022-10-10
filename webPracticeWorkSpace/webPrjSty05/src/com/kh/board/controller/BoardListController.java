package com.kh.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.board.service.BoardService;
import com.kh.board.vo.BoardVo;
import com.kh.member.vo.MemberVo;
@WebServlet(urlPatterns = "/board/list")
public class BoardListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession ss = req.getSession();
		MemberVo loginMem = (MemberVo)ss.getAttribute("loginMem");
		
		if(loginMem != null) {	
			List<BoardVo> voList = new BoardService().selectList();
			if(voList != null) {
				req.setAttribute("voList", voList);
				req.getRequestDispatcher("/views/board/list.jsp").forward(req, resp);
			}
		} else {
			req.setAttribute("msg", "로그인해주세요");
			req.getRequestDispatcher("/views/common/error.jsp").forward(req, resp);
		}
		

		
	}

	
	
}
