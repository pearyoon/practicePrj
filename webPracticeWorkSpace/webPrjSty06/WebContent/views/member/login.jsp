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
        /* border: 1px solid black; */
    }
    #login-wrap{
        width: 300px;
        margin: 0 auto;
    }
    #login-top{
        margin-top: 30px;
        
    }
    
    input,button{
        width: 100%;
        height: 46px;
        padding: 0px 11px 1px 15px;
        border-radius: 4px;
        border: 1px solid rgb(221, 221, 221);
        font-weight: 400;
        font-size: 16px;
        line-height: 1.5;
        color: rgb(51, 51, 51);
        outline: none;
        box-sizing: border-box;
        margin-bottom: 10px;
    }

    input[type=submit]{
        background-color: plum;
        color: white;
    }
    button{
        background-color: white;
        border-color: plum;
        margin-bottom: 30px;
    }
    #findMem{
        padding-bottom: 15px;
        display: flex;
        justify-content: end;
        font-size: small;
    }
</style>
</head>
<body>
<%@include file="/views/common/header.jsp" %>
	<main>
        <h1>로그인</h1>
        <hr>
        <div id="login-wrap">
            <form action="/appSty06/member/login" method="post">
                <div id="login-top">
                    <div>
                        <input type="text" name="memberId" placeholder="아이디를 입력해주세요.">
                    </div>
                    <div>
                        <input type="password" name="memberPwd" placeholder="비밀번호를 입력해주세요.">
                    </div>
                </div>
                <div id="findMem">
                    <a href="/appSty06/member/findId">아이디 찾기 </a>
                    <span> | </span>
                    <a href="/appSty06/member/findPwd"> 비밀번호 찾기</a>
                </div>
                <div id="btn">
                    <div>
                        <input type="submit" value="로그인"> 
                    </div>
                    <div>
                        <button>회원가입</button>
                    </div>   
                    
                </div>
    
                        
    
            </form>
    


        </div>
        <hr>
    </main>
</body>
</html>