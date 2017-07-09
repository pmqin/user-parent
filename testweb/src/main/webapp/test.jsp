<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>当前时间</title>
</head>
<body>
<%=(new Date()).toString() %>

<%
String str=request.getParameter("num");
String useName=request.getParameter("usename");
int n=Integer.parseInt(str);
int sum=0;
for(int i=1; i<=n;i++)
{
	sum=sum+i;
	}

%>

<p><%=useName %>
<br>
从1到<%=n %>累加的和是:<%=sum %></p>
</body>
</html>