<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 목록</h1>
	<hr>
	<form action="/mb02/board/list" method="get">
		<select name="category">
			<option value="title">제목</option>
			<option value="nick">작성자</option>
		</select>
		<input type="text" name="search">
		<input type="submit" value="검색">
	</form>
	<hr>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
		</tr>
		
		<c:forEach items="${voList}" var="list">
			<tr>
				<td>${list.no }</td>
				<td>${list.writer }</td>
				<td>${list.title }</td>
				<td>${list.enrollDate }</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<a href="/mb02/board/write">작성하기</a>

</body>
</html>