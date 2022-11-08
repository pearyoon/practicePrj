<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원조회</title>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
	.wrap{
		width: 800px;
		margin: 0 auto;
		text-align: center;
	}

	.flex-wrap{
		display: flex;
		justify-content: space-around;
	}
</style>
</head>
<body>
	<div class="wrap">
		<h1>모든회원정보</h1>
		<div class="flex-wrap">
			<div>번호</div>
			<div>아이디</div>
			<div>이름</div>
			<div>가입일</div>
			<div>탙퇴</div>
		</div>
	<c:forEach var="voList" items="${voList}">
		<div class="flex-wrap">
			<div>${voList.no}</div>
			<div>${voList.id}</div>
			<div>${voList.name}</div>
			<div>${voList.enrollDate}</div>
			<div>${voList.status}</div>
		</div>
	</c:forEach>
	</div>

</body>
</html>