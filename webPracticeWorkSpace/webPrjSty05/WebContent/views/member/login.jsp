<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<style>
	#main{
		width: 60vw;
		height: 60vh;
		/* border: 5px solid blueviolet; */
		margin: auto;
		text-align: center;
	}
	
	table {
    margin-left:auto; 
    margin-right:auto;
	}

	#btn{
		margin-left: 108px;
	}

	#login-area{
		margin-top: 20px;
	}

	</style>
<body>
<%@include file="/views/common/header.jsp" %>

	<div id="main">
		<h1>로그인</h1>
		<hr>
		<form action="/appSty05/member/login" method="post">
			<div id="login-area">
				<table>
					<tr>
						<th>아이디</th>
						<td><input type="text" name="memberId"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="memberPwd"></td>
					</tr>		
			   </table>
			   <div id="btn">
					<input type="submit" value="로그인">
					<input type="button" value="회원가입" onclick="location.href='/appSty05/member/join'">
			   </div>
			</div>
		</form>
	</div>

</body>
</html>