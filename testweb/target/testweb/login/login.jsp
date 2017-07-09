<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	/* String user = request.getParameter("user")==null?"pleaseusename":request.getParameter("user");
		String user2 = new String(user.getBytes("UTF-8"), "GBK"); */
	%>
	<h2>username=秦鹏明&password=admin</h2>
	<!-- 由 checklogin.jsp处理表单数据 -->
	<form action="checklogin.jsp" method="get">
		<table>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username"
					value=<%=request.getParameter("user")%>></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="login"></td>
			</tr>
		</table>
	</form>

</body>
</html>