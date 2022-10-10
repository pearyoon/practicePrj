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
	table{
		margin-left:auto; 
		margin-right:auto;
		width: 100%;
		height: 100%;
		/* border: 1px solid black; */
		border-collapse: collapse;
	}
	th {
		border: 1px solid black;
		padding: 10px;
		width: 20%;

	}
	td:not(#btn){
    	border: 1px solid black;
		width: 80%;
    	padding: 10px;
  	}
	table tr:nth-child(1){
		height: 10%;
	}
	table tr:nth-child(2){
		height: 90%;
	}
	table tr:last-child{
		text-align: end;
	}

	input[name=title]{
		width: 100%;
		height: 100%;
		border: none;
	}

	textarea {
		width: 100%;
		height: 100%;
		border: none;
		resize: none;
  	}
</style>
</head>
<body>
	<%@include file="/views/common/header.jsp" %>
	<div id="main">
		<h1>게시글 작성</h1>
		<table>
			<form action="/appSty05/board/write" method="post">
				
					<tr>
						<th>제목</th>
						<td><input type="text" name="title"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="content"></textarea> </td>
					</tr>
					<tr>
						<td colspan="2" id="btn"><input type="submit" value="작성하기"></td>
					</tr>
			</form>
		</table>

	</div>
	
</body>
</html>