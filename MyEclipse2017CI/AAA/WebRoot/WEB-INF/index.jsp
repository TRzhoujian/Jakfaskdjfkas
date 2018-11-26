<%@page import="smis.domain.Student"%>
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
    
    <title>俺の初めでのJsp</title>
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
     <a href="/student?cmd=edit">AddStudent:がくせをついかする</a>	
     <table border = "1" width="80%" cellpadding="0" cellspacing="0">
     	<tr>
     		<th>ID:アイディー</th>
     		<th>Name:なまえ（名前）</th>
     		<th>age:ねんれい（年齢）</th>
     		<th>Operation:そうさ（操作）</th>
     	</tr>
     	
     	<c:forEach items="${students}" var="s" varStatus="vs">
     		<tr>
				<th>${vs.count}</th>
				<th>${s.name}</th>
				<th>${s.age}</th>
				<th>
					<a href="/student?cmd=delete&id=${s.id}">delete：けずる（削る）</a>
					<a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</a>
					<a href="/student?cmd=edit&id=${s.id}">edit：へんしゅう（編集）</a>
				</th>
			</tr>
     	
     	</c:forEach>
     </table>
  </body>
</html>
