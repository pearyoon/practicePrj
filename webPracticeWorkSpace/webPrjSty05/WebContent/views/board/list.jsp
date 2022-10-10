<%@page import="com.kh.board.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<BoardVo> voList = (List<BoardVo>)request.getAttribute("voList");
%>
<%
	BoardVo boardVo = (BoardVo)request.getAttribute("boardVo");
%>
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
		/* border: 1px solid black; */
		border-collapse: collapse;
	}
  	th, td:not(#btn){
    	border: 1px solid black;
    	padding: 10px;
  	}
	table th:nth-child(1),table th:nth-child(2){
		width: 80px;
	}

	table th:nth-child(3){
		width: 200px;
	}

	table th:last-child{
		width: 1000px;
	}
	table tr:last-child{
		text-align: end;
	}
</style>
</head>
<body>
	<%@include file="/views/common/header.jsp" %>
	<div id="main">
		<%if(boardVo != null){%>
			<script>
				alert("글 작성 성공");
			</script>
		<%} %>
		<h1>일반게시판</h1>
		<hr>
		<table>
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>내용</th>
			</tr>
			<% for(int i = 0; i < voList.size(); i++){ %>
				<tr>
					<td><%=voList.get(i).getNo() %></td>
					<td><%=voList.get(i).getMemNo() %></td>
					<td><%=voList.get(i).getTitle() %></td>
					<td><%=voList.get(i).getContent() %></td>
				</tr>
			<%} %>
			<tr>
				<td colspan="4" id="btn">
					<button><a href="/appSty05/board/write">작성하기</a></button>
				</td>
			</tr>
		</table>
		
	</div>
</body>
</html>