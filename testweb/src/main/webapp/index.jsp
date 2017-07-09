<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>测试ServletContextAttributeListenter</title>
</head>
<body>

	<h1>测试ServletContextAttributeListenter，来自Hello.java</h1>
	<%
	Object servletContext = getServletContext().getAttribute("peng");
		
	if (servletContext != null) {  
		out.print((String)servletContext);
	}
	else
	{
		out.print("getServletContext().removeAttribute(peng);移除了，请打开看结果");
	}
	%>
</body>
</html>
