<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<body>
	<%
	    ArrayList  showList = (ArrayList) (getServletContext().getAttribute("list"));
		out.print("在线人数 " + showList.size() + "<br>");
		for (int i = 0; i < showList.size(); i++) {
			out.print(showList.get(i) + "在线" + "<br>");
		}
		session = request.getSession();  
		
		out.print("当前的用户sessionid="+session.getId());
	%>
	<br>
	<a href="sessiontest.jsp">退出</a>
</body>
</html>