<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    #info-main{
		width: 60vw;
		height: 60vh;
		/* border: 5px solid blueviolet; */
		margin: auto;
		text-align: center;
	}
    #info-main>div{
        padding: 10px;
    }
</style>
</head>
<body>
<%@include file="/views/common/header.jsp" %>
	<div id="info-main">
        <h1>마이페이지</h1>
        <div>아이디 : <%=loginMem.getId() %></div>
        <div>닉네임 :<%=loginMem.getNick() %></div>
        <div>주소 : <%=loginMem.getAddr() %></div>
        <div>취미 : <%=loginMem.getHobby() %></div>
    </div>

</body>
</html>