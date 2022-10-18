package com.kh.appSty06.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.kh.appSty06.board.vo.AttachmentVo;
import com.kh.appSty06.common.FileUploader;
import com.kh.appSty06.member.vo.MemberVo;
@WebServlet(urlPatterns = "/board/write")

@MultipartConfig(
			fileSizeThreshold = 1024 * 1024 * 50,
			maxFileSize = 1024 * 1024 * 50,
			maxRequestSize = 1024 * 1024 * 50 *5
			
		)


public class BoardWriteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ss = req.getSession();
		MemberVo loginMember = (MemberVo)ss.getAttribute("loginMember");
		
		if(loginMember == null) {
			req.setAttribute("msg", "로그인 후 이용해주세요.");
			req.getRequestDispatcher("/views/common/error.jsp").forward(req, resp);
			
			return;
		}
		
		req.getRequestDispatcher("/views/board/write.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		HttpSession ss = req.getSession();
		MemberVo loginMember = (MemberVo)ss.getAttribute("loginMember");
		
		String category = req.getParameter("category");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		Part f = req.getPart("f");
		
		AttachmentVo attVo = null;
		
		// -------- 파일 업로드 ------------
		
		if(f.getSubmittedFileName().length() > 0) {
												// 최상단 경로			
			attVo = FileUploader.uploadFile(f, req.getServletContext().getRealPath("/"));
		}
		
		// -------- 파일 업로드 완 ---------
	}
}
