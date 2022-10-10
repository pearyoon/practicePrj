<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	main{
		width: 60vw;
		height: 60vh;
		margin: 0 auto;
		text-align: center;
		align-content: center;
	}
	#join-area{
		margin-top: 50px;
		display: grid;
		grid-template-columns: 1fr 1fr;
		grid-template-rows: repeat(8, 30px);
		row-gap: 10px;
	}
	#join-area input[type="text"],#join-area input[type="password"]{
		width: 50%;
		height: 70%;
		margin: 0 auto;
	}
	input[type="submit"]{
		width: 100px;
		height: 40px;
	}
</style>
</head>
<body>
	<%@include file="/views/common/header.jsp" %>

	<main>
		<h1>회원가입</h1>
		<hr>
		<form action="/appSty06/member/join" method="post" onsubmit="return check();">
			<div id="join-area">
				<div>아이디</div>
				<div><input type="text" name="memberId"></div>
				<div>비밀번호</div>
				<div><input type="password" name="memberPwd1"></div>
				<div>비밀번호 확인</div>
				<div><input type="password" name="memberPwd2"></div>
				<div>닉네임</div>
				<div><input type="text" name="memberNick"></div>
				<div>주소</div>
				<div><input type="text" name="addr"></div>
				<div>취미</div>
				<div>
					<label>코딩
						<input type="checkbox" name="hobby" value="coding">
					</label>
					<label>독서
						<input type="checkbox" name="hobby" value="reading">
					</label>
					<label>영화 보기
						<input type="checkbox" name="hobby" value="movie">
					</label>
				</div>
			</div>
			<div><input type="submit" value="회원가입"></div>
		</form>	
	</main>	

	<script>
		const pwd1 = document.querySelector("input[name=memberPwd1]");
		const pwd2 = document.querySelector("input[name=memberPwd2]");

		function check(){
			
			if(pwd1.value.length > 0 && pwd1.value == pwd2.value){
				return true;
			} else{
				alert("비밀번호를 확인해주세요!");
				return false;
			}
		}
	</script>

</body>
</html>