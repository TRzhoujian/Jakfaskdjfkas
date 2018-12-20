<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/struts-dojo-tags" prefix="sx" %>
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
  </head>
  
  <body>
  <sx:head extraLocales="UFT-8"/>
     <h2>添加员工</h2>
     <s:form action="/oa/employee_save" theme="simple">
     <s:hidden name="e.id"></s:hidden>
     	姓名:<s:textfield name="e.name"/><br>
     	密码:<s:password name="e.password" showPassword="true"/><br>
     	邮箱:<s:textfield name="e.email"/><br>
     	日期:<sx:datetimepicker name="e.hireDate" language="UFT-8" displayFormat="yyyy-MM-dd"/><br>
     	<s:submit value="提交"></s:submit>
     </s:form>
  </body>
</html>
