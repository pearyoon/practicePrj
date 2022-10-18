<%@page import="com.kh.sty08.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
	String alertMsg = (String)session.getAttribute("alertMsg");
	session.removeAttribute("alertMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		<%if(alertMsg != null) {%>
			alert("<%=alertMsg%>");
		<%}%>
	</script>
	
	<h1>회원정보조회</h1>
		<h3>등급 : <%=loginMember.getGrade() %></h3>
		
		<form action="/sty08/member/mypage" method="post" onsubmit="return check()">
			아이디 : <input type="text" name="id" readonly value="<%=loginMember.getId() %>">
			<br>
			새 비밀번호 : <input type="password" name="pwd1">
			<br>
			새 비밀번호 확인 : <input type="password" name="pwd2">
			<br>
			닉네임 : <input type="text" name="nick" value="<%=loginMember.getNick() %>">
			<br>
			주소 : <input type="text" name="addr" value="<%=loginMember.getAddr() %>">
			<br>
			번호 : <input type="text" name="phone" value="<%=loginMember.getPhone() %>">
			<br>
			<input type="submit" value="수정하기">
			<button type="button" onclick="location.href='/sty08'">취소</button>
		</form>
		
	<script>
		const pwd1 = document.querySelector("input[name=pwd1]");
		const pwd2 = document.querySelector("input[name=pwd2]");
		
		function check(){
			if(pwd1.value.length > 3 && pwd1.value == pwd2.value){
				return true;
			} else{
				alert("비밀번호를 확인해주세요.");
				return false;
			}
		}
	</script>
</body>
</html>