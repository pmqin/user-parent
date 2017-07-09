<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="404.jsp" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
  String count=(String)application.getAttribute("count");

 if(count==null)
 {
	 count="1";
 }
 else
 {
	 count=Integer.parseInt(count)+1+"";
 }
 application.setAttribute("count", count);
 
 int a=2;
 int b=0;
 double c=a/b;
%>

<%="<h1>到目前为止，用户数有:"+count+"人</h1><br>" %>
</body>
</html>