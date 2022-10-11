<%@page import="java.util.List"%>
<%@page import="com.kh.appSty06.board.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<BoardVo> voList = (List<BoardVo>)request.getAttribute("voList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
    main{
        position: absolute;
        left: 50%;
        transform: translate(-50%);
        width: 60vw;
        height: 60vh;
        margin: 0 auto;
    }
    #list-area{

        text-align: center;
    }
    .list-wrapper{
        display: grid;
        grid-template-columns: 1fr 2fr 3fr 2fr 1fr;
        padding-bottom: 5px;
        padding-top: 5px;
        border-bottom: 1px solid gray;
    }
    #list-area>div:first-child{
        padding-bottom: 10px;
        padding-top: 10px;
        font-weight: bold;
        border-bottom: 1px solid black;
        border-top: 1px solid black;
    }
    #btn{
        position: absolute;
        width: 60vw;
        bottom: 20px;
        left: 0;

        text-align: end;
    }
</style>
<title>Insert title here</title>
</head>
<body>
	<%@include file="/views/common/header.jsp" %>
    <h1 align="center">게시판</h1>
    <main>
        <div id="list-area">
            <div class="list-wrapper">
                <div>번호</div>
                <div>작성자</div>
                <div>제목</div>
                <div>작성일시</div>
                <div>조회수</div>
            </div>
            <%if(voList != null) {
            	for(int i = 0; i < voList.size(); i++) {%>
		            <div>
                        <a href="/appSty06/board/detail?no=<%= voList.get(i).getNo() %>&isEdit=false" class="list-wrapper">
                            <div><%=voList.get(i).getNo() %></div>
                            <div><%=voList.get(i).getWriter() %></div>
                            <div><%=voList.get(i).getTitle() %></div>
                            <div><%=voList.get(i).getModifyDate() %></div>
                            <div><%=voList.get(i).getHit() %></div>
                        </a>
		            </div>
            	<%} %>
           <%} else {%>
           		<div>작성된 글이 없습니다.</div>
           <%} %> 

        </div>
        <div id="btn">
            <a href="">글쓰기</a>
        </div>
    </main>
  
</body>
</html>