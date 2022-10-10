<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#main{
		width: 60vw;
		height: 60vh;
		/* border: 5px solid blueviolet; */
		margin: auto;
		text-align: center;
	}
	form{
		width: 100%;
		height: 70%;
	}
	#join-area{
		width: 80%;
		height: 100%;
		/* border: 1px solid red; */
		display: grid;
		grid-template-columns: 1fr 4fr;
		grid-template-rows: repeat(7, 1fr);
		margin-left: 30%;
	}
	#join-area>div{
		width: 80%;

	}
</style>
</head>
<body>
	<%@include file="/views/common/header.jsp" %>
	<div id="main">
		<h1>회원가입</h1>
		<form action="/appSty05/member/join" method="post">
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
				<div>회원가입</div>
				<div><input type="submit" value="회원가입"></div>
			
			</div>
		</form>
	</div>

	<script>
		const pwd1 = document.querySelector("input[name=memberPwd1]");
		const pwd2 = document.querySelector("input[name=memberPwd2]");


		pwd2.addEventListener("blur", function(){
			if(pwd1.value == pwd2.value){
			alert("일치");
			} else{
				alert("불일치");
			}
		});

	</script>

</body>
</html>