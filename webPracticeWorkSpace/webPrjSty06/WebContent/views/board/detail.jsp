<%@page import="com.kh.appSty06.board.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	BoardVo vo = (BoardVo)request.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/views/common/header.jsp" %>
	<h1>게시글 상세 조회</h1>
	<div id="wrapper">
		<div>
			<div></div>
		</div>
		<div>
			<textarea name="" id="" cols="30" rows="10"></textarea>
		</div>
	</div>
	
</body>
</html>