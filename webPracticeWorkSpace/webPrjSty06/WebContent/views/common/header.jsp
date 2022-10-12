<%@page import="com.kh.appSty06.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String alertMsg = (String)session.getAttribute("alertMsg");
	session.removeAttribute("alertMsg");
%>

<%
	MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
%>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<style>

    body, html{
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    a{
        text-decoration: none;
        color: black;
    }
    #header-container{
        width: 80vw;
        height: 20vh;
        margin: auto;
        text-align: center;
    }
    header{
        width: 100%;
        height: 100%;
        
    }
    #header-top{
        height: 80%;
        display: flex;
        justify-content: space-around;
        background-color: cornflowerblue;
        
    }
    #logo{
        width: 40%;
        background-image: url('/appSty06/resources/img/logo.jpg');
        background-size: cover;
    }
    #menu-bar{
        height: 20%;
        background-color: hotpink;
        font-size: 1.4rem;
        display: flex;
        justify-content: space-around;
    }
    #member-area{
        margin-top: auto;
        margin-bottom: auto;
    }
    
</style>
	<%if(alertMsg != null){ %>
		
	    <script>
     		alert('<%=alertMsg %>');
    	</script>
		
	<%} %>

    
	<div id="header-container">
        <header>
            <div id="header-top">
                <div id="logo"></div>
                <div id="member-area">
                <%if(loginMember != null) {%>
                	<span><a href="/appSty06/member/myPage">마이페이지</a></span>
                    &nbsp;
                    <span><a href="/appSty06/member/logout">로그아웃</a></span>
                    <div><%=loginMember.getNick() %> 회원님 </div>
                 
                <%}else{ %>
               		<span><a href="/appSty06/member/join">회원가입</a></span>
               		&nbsp;
                    <span><a href="/appSty06/member/login">로그인</a></span>
                 
                <%} %>
                </div>
            </div>
            <div id="menu-bar">
                <div class="items"><a href="/appSty06/board/list?pno=1">게시판</a></div>
                <div class="items">게시판2</div>
                <div class="items">게시판3</div>
                <div class="items">게시판4</div>
            </div>
        </header>
    </div>