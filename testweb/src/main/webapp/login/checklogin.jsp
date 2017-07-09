<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CheckLogin</title>
</head>
<body>
    <%
    
    request.setCharacterEncoding("UTF-8");
      //与login.jsp中name="username"对应
       String name = request.getParameter("username");
      
       //与login.jsp中name="password"对应
       String password = request.getParameter("password");
       if (name.equals("秦鹏明") && password.equals("admin")) {
    %>
          <!--  跳转至success.jsp -->
    <jsp:forward page="success.jsp">
       <jsp:param name="user" value="<%=name%>" />
    </jsp:forward>
    <%
    } else {
    %>
    <!-- 跳转至login.jsp -->
    <jsp:forward page="login.jsp">
       <jsp:param name="user" value="<%=name%>" />
    </jsp:forward>
    <%
    }
    %>
</body>
</html>