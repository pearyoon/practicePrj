<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>

	<h1>에러페이지</h1>
	<h2>${errorMsg}</h2>
	<button type="button">HOME</button>
	
	<script>
		$('button[type="button"]').click(function(){
			window.location.href = "/sty09";
		});
	</script>
</body>
</html>