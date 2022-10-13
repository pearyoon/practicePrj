<%@page import="com.kh.appSty07.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String alertMsg = (String)session.getAttribute("alertMsg");
    	session.removeAttribute("alertMsg");
    	String root = (String)request.getContextPath();
    	MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(alertMsg != null){ %>
		
	    <script>
     		alert('<%=alertMsg %>');
    	</script>
		
	<%} %>
	<h1>회원가입/로그인 연습</h1>
	
	<%if(loginMember != null) {%>
		<div>
			<%=loginMember.getNick() %>님 환영합니돠~
		</div>
		<div>
			<a href="<%=root %>/member/logout">로그아웃</a>
		</div>
	<%} else {%>			
		<div>
			<a href="<%=root %>/member/join">회원가입</a>
		</div>
		<div>
			<a href="<%=root %>/member/login">로그인</a>
		</div>
	<%} %>

</body>
</html>