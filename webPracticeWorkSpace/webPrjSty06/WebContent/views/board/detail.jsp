<%@page import="com.kh.appSty06.board.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	BoardVo vo = (BoardVo)request.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	div{
		box-sizing: border-box;
	}
	h1{
		text-align: center;
	}
	main{
        position: absolute;
		top: 300px;
        left: 50%;
        transform: translate(-50%);
        width: 60vw;
        height: 60vh;
        margin: 0 auto;
		
    }

	#detail-wrap{
		height: 100%;
		display: grid;
		grid-template-rows: 2fr 5fr 1fr;
	}

	#title-area{
		width: 100%;
		height: 100%;
		border: 1px solid black;
	}
	.info-area{
		display: flex;
		justify-content: flex-start;
		width: 100%;
		
	}
	.info-area>div:first-child{
		padding: 10px;
		width: 100px;
		height: 50px;
		background-color: gray;
		color: white;
		border-bottom: 1px solid black;
	}
	.info-area>div:last-child{
		padding: 10px;
		width: 100%;
		height: 50px;
		border-bottom: 1px solid black;
	}
	#content-area{
		width: 100%;
		height: 100%;
		border: 1px solid black;
	}
	#content-area>div{
		padding: 10px;
	}

	#btn{
		text-align: end;
		padding: 10px;
	}

</style>
<title>Insert title here</title>
</head>
<body>
	<%@include file="/views/common/header.jsp" %>
	<h1>게시글 상세 조회</h1>
	<main>
		<div id="detail-wrap">
			<div id="title-area">
				<div class="info-area">
					<div>
						제목 
					</div>
					<div><%=vo.getTitle() %></div>
				</div>
				<div class="info-area">
					<div>작성자</div>
					<div><%=vo.getWriter() %></div>
				</div>
				<div class="info-area">
					<div>작성일시</div>
					<div><%=vo.getModifyDate() %></div>
				</div>
			</div>
	
			<div id="content-area">
				<div><%=vo.getContent() %></div>
			</div>
			
			<div id="btn">
				<a href="/appSty06/board/edit?no=<%=vo.getNo() %>">수정</a>
				<span>|</span>
				<a href="/appSty06/board/delete">삭제</a>
				<span>|</span>
				<a href="/appSty06/board/list?pno=1">목록</a>
			</div>

		</div>

	</main>
	
</body>
</html>