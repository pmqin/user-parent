<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html >
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My JSP 'sessiontest.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="${contextPath}">
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	//HttpServletRequest.getSession(ture) 等同于 HttpServletRequest.getSession()，若当前存在Session则返回该会话，否则新建一个Session;
    ///HttpServletRequest.getSession(false) 等同于： 若当前存在Session则返回该会话，否则返回NULL，因此，一般情况下，尽量要明确使用参数为false的写法。
		session = request.getSession(false);
       // 注销用户，使session失效。//方法1 request.getSession().removeAttribute("userName");
		if (session != null)
			session.invalidate();
	%>
	<form action="isOnline.jsp" method="post">
		用户名： <input type="text" name="uName" /> <input type="submit"
			value="上线">
	</form>
</body>
</html>

