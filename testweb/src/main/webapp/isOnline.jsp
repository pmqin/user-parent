<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html">
<html>
<head>
<link rel="stylesheet" href="${contextPath}/ace/assets/css/bootstrap.css" />
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My JSP 'isOnline.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<body>
	<%
	    request.setCharacterEncoding("UTF-8");
		session = request.getSession();

		session.setAttribute("userName", request.getParameter("uName"));

		response.sendRedirect("showOnline.jsp");//重定向 ，地址改变 
	%>
</body>
</html>