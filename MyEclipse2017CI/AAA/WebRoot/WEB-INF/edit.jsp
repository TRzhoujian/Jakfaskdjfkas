<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'edit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    	<form action="/student?cmd=save" method="POST">
    	<input type="hidden" name ="id" value="${student.id}"/>
    		name：名前（なまえ）<input type="text" name="name" required value="${student.name}"/><br/>
    		age：年齢（ねんれい）<input type="number" name="age" required value="${student.age}"/><br/><br/>
    		<input type="submit" value='${student==null ? "saveStudent:保存学生の情報（ほぞんがくせいのじょうほう）":"updateStudent:更新学生の情報（こうしんがくせいのじょうほう）"}'/>
    	</form>
  </body>
</html>
