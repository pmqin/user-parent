<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>



	<!-- html的客户端注释，客户端可以看到 -->
	<%-- 服务器端注释，页面不能看到 --%>
	<h1>Hello - ${user.userName} - ${user.adderName} -${user.mobileNo}</h1>


	<p>11111等闲变却故人心，却道故人心易变。硕士生g</p>
	<p>11111骊山语罢清宵半，泪雨霖铃终不怨。</p>
	<p>11111何如薄幸锦衣郎，比翼连枝当日愿。</p>
	<%!
	int num = 1;

	public String printStr() {
		return "返回方法的值";
	}
	String str="JSP,expression";
	%>
	<%
		int ddd = 2;
		//不能加System. 表达式不能满足要求的时候可以用这个做复杂的操作
		out.println("num=" + (num + ddd) + "Printstring" + printStr());
	%>
	<br>
	表达式的值：
	<%=str %>
	<%=printStr() %>
	<br />
	<br />
	<br />
	该指令包含静态文件，在运行时如果改变了 被包含的文件是不会改变的，必须重新保存该jsp文件，然后访问它才会变化
	<%@ include file="file/include.txt"%> 
	
	<br>
	
	<!-- 子页面定义了获取父的值，必须要指定name value 这个的方式不行test.jsp?num=100，必须用param元素 -->
	<%-- <jsp:forward page="test.jsp">
	<jsp:param value="100" name="num"/>
	<jsp:param value="jack" name="usename"/>
		</jsp:forward> --%>
	
	<!-- 使用jsp:include动作元素 导入jsp文件，并传参 -->
	<jsp:include page="test.jsp">
	<jsp:param value="100" name="num"/>
	<jsp:param value="jack" name="usename"/>
	</jsp:include> 
	
<%-- 	<%@ include file=”http://www.baidu.com”%> --%>
<%-- 	<jsp:include page="test.jsp"> --%>
	
<%-- 	</jsp:include>  --%>
</body>
</html>