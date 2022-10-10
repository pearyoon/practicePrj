<%@page import="com.kh.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVo loginMem = (MemberVo)session.getAttribute("loginMem");
%>

<style>
    html , body {
        padding: 0;
        margin: 0;
    }
    div{
        box-sizing: border-box;
        /* border: 1px solid black; */
    }
	#header{
        width: 80vw;
        height: 25vh;
        margin: auto;
	}
    #header-top{
        width: 100%;
        height: 80%;
        /* display: flex;
        justify-content: space-between; */
        display: grid;
        grid-template-columns: 2fr 5fr 2fr;
        background-color: deepskyblue;
    }
    #logo-box, #member-box{
        width: 100%;
        height: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    #header-bottom{
        width: 100%;
        height: 20%;
        display: flex;
        justify-content: space-around;
        font-size: 1.5rem;
        background-color: cornflowerblue;
    }
    a{
        text-decoration: none;
        color: black;
    }
    #member-box>div{
        padding: 10px;
    }
    


</style>

	<div id="header">

        <div id="header-top">
            <div></div>
            <div id="logo-box">
                <img src="/appSty05/resources/image/logo.jpg" alt="로고이미지" style="width: 80%; height: 80%;">
            </div>
            <div id="member-box">
            	<%if(loginMem == null) {%>
	                <div><a href="/appSty05/member/join">회원가입</a></div>
	                <div><a href="/appSty05/member/login">로그인</a></div>
                <%}else{ %>
            		<div><a href="/appSty05/member/info">마이페이지</a></div>
	                <div><a href="/appSty05/member/logout">로그아웃</a></div>
	            <%} %>    
            </div>
        </div>
        <div id="header-bottom">
            <div>HOME</div>
            <a href="/appSty05/board/list"><div>일반게시판</div></a> 
            <div>사진게시판</div>
            <div>공지사항</div>
        </div>
    </div>
