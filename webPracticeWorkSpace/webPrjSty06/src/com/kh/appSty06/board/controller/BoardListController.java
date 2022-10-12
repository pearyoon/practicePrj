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
import com.kh.appSty06.common.PageVo;
@WebServlet(urlPatterns = "/board/list")
public class BoardListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int listCount; 		// 총 게시물 개수
		int currentPage; 	// 현재 페이지
		int pageLimit;		// 페이징 바 최대 개수
		int boardLimit;		// 게시글 최대 개수
		
		int maxPage;		// 가장 마지막 페이지
		int startPage;		// 페이징바 시작페이지
		int endPage;		// 페이징바 종료 페이지
		
		listCount = new BoardService().selectCount();
		currentPage = Integer.parseInt(req.getParameter("pno"));
		pageLimit = 5;
		boardLimit = 10;
		
		/*
		 * maxPage : listCount, boardLimit으로 계산
		 * 
		 *	listCount 나누기 boardLimit의 소수점이 0이 아니라면 모두 올려준다.
		 */
		maxPage = (int)Math.ceil((double)(listCount / boardLimit));
		
		/*
		 * startPage : pageLimit, currentPage로 계산
		 * 
		 * ex) pageLimit(페이징바 목록)이 10개라면,,,
		 * 	   startPage 후보 : 1 , 11 , 21 , 31 , 41 ...
		 * 					=> n * pageLimit + 1
		 */
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		/*
		 * endPage : startPage, PageLimit으로 계산 (+ maxPage도 고려해야함
		 * ex) pageLimit : 10
		 * startPage  => endPage
		 * 		1	  => 	10
		 * 		11	  =>	20 	
		 * 
		 * endPage = startPage + pageLimit - 1;
		 */
		
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageVo pv = new PageVo();
		pv.setListCount(listCount);
		pv.setCurrentPage(currentPage);
		pv.setPageLimit(pageLimit);
		pv.setBoardLimit(boardLimit);
		
		pv.setMaxPage(maxPage);
		pv.setStartPage(startPage);
		pv.setEndPage(endPage);
		
		List<BoardVo> voList = new BoardService().selectAllList(pv);
		
		req.setAttribute("pv", pv);
		req.setAttribute("voList", voList);
		req.getRequestDispatcher("/views/board/list.jsp").forward(req, resp);

	}
}
