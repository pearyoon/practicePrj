<%@page import="com.kh.appSty06.common.PageVo"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.appSty06.board.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<BoardVo> voList = (List<BoardVo>)request.getAttribute("voList");
%>
<%
	PageVo pv = (PageVo)request.getAttribute("pv");
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
    #list-bottom>div:first-child, #list-bottom>#btn>a{
        width: 80px;
    }
    #list-bottom{
        margin-top: 50px;
        display: flex;
        justify-content: space-between;
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
                        <a href="/appSty06/board/detail?no=<%= voList.get(i).getNo() %>" class="list-wrapper">
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
        <div id="list-bottom">
            <div></div>
            <div id="page">
       		
                <%if(pv.getStartPage() != 1) {%>
                    <a href="/appSty06/board/list?pno=<%=pv.getStartPage()-1 %>" class="btn btn-primary btn-sm">이전</a>
                <%} %>
                
                <% for(int i = pv.getStartPage() ; i <= pv.getEndPage(); ++i){ %>
                        <a href="/appSty06/board/list?pno=<%=i %>" class="btn btn-primary btn-sm"><%=i %></a>
                <%} %>
                   
                   <% if(pv.getEndPage() != pv.getMaxPage()) {%>
                        <a href="/appSty06/board/list?pno=<%=pv.getEndPage()+1 %>" class="btn btn-primary btn-sm">다음</a>
                   <%} %>
                
            </div>
            <div id="btn">
                <a href="/appSty06/board/write" class="btn btn-primary btn-sm">글쓰기</a>
            </div>
        </div>


    </main>
  
</body>
</html>