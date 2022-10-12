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
		text-align: start;
	}

	#content-area textarea{
		width: 100%;
		height: 100%;
		border-style: none;
	}
	#btn{
		text-align: center;
	}
	.info-area input{
		border-style: none;
	}

</style>
<title>Insert title here</title>
</head>
<body>
	<%@include file="/views/common/header.jsp" %>
	<h1>게시글 수정하기</h1>
	<main>

		<div id="detail-wrap">
			<form action="" method="post">
				<div id="title-area">
					<div class="info-area">
						<div>제목 </div>
						<div>
							<input type="text" name="title" value="<%=vo.getTitle() %>">    
						</div>
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
					<div>
						<textarea name="content" rows="20"><%=vo.getContent() %></textarea>
					</div>
				</div>
				
				<div id="btn">
					<input type="submit" value="수정하기" ></a>
				</div>
	
			</form>
			
		</div>

	</main>
	
</body>
</html>