<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>登录页面</h2>
	<span style="color: red;">${errorMsg}</span>
	<form action="/login" method="post">
		账号:<input name="username"/><br/>
		密码:<input type="password" name="password"/><br/>
		<input type="submit" value="登录"/>	 
	</form>
</body>
</html>