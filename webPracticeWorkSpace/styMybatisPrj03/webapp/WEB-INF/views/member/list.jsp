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

	<h1>회원조회</h1>
	<form action="/mb03/member/list" method="get">
		<input type="hidden" value="1" name="p">
		<select name="category">
			<option value="member_id">아이디</option>
			<option value="member_nick">닉네임</option>
		</select>
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
	<hr>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>닉네임</th>
		</tr>
		<c:forEach items="${voList}" var="voList">
			<tr>
				<td>${voList.memberId }</td>
				<td>${voList.memberNick }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>