package com.kh.sty09.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kh.sty09.member.vo.MemberVo;
@WebFilter(urlPatterns = "/login/*")
public class LoginFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpSession ss = req.getSession();
		MemberVo loginMem = (MemberVo)ss.getAttribute("loginMember");
		
		if(loginMem == null) {
			req.setAttribute("errorMsg", "로그인 후 이용해주세요.");
			req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(request, response);
			return;
		}
		
		chain.doFilter(req, response);
		
		
	}
}
