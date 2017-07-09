<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSPuseBean</title>
</head>
<body>
<!-- 可以不用使用这些 import="com.cn.pmqin.model.UserRole"
               环境使用错误总结 里面日志 The value for the useBean class attribute XXX is invalid 异常绝对详解释 详见错误方法
-->
<%-- <%@ page isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
设置及输出用户信息：
<jsp:useBean id="UserRoleBean" class="pmqin.model.UserRole" scope="page"/>

<jsp:setProperty property="roleName" name="UserRoleBean" value="qinpm"/>
<jsp:setProperty property="adderName" name="UserRoleBean" value="1880154254"/>

用户名：<jsp:getProperty property="roleName" name="UserRoleBean"/>
地址：<jsp:getProperty property="adderName" name="UserRoleBean"/>
<%! String str="学习JSP_UseBean";
%>
<%=str+"<br>" %>

<h1>除了可以用jsp:getProperty来显示标签的指令外，out.println() 方法也可以</h1>
<% 
out.println(UserRoleBean.getAdderName()+"<br>");
out.println(UserRoleBean.getRoleName());
%>
</body>
</html>