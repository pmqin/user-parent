<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ taglib uri="/pmqin" prefix="pm"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试标签体</title>
</head>
<body>

    <!-- 输出标签里面的内容 -->
	<pm:timer></pm:timer>  <br> 
	<!-- 显示标签的内容 -->
    <pm:date pattern="yyyy-MM-dd hh:mm:ss" /> <br> 
    
    <pm:loop times="3">      
            循环多次    fdf
    </pm:loop> 
<%-- 	<pm:loop times="3">       --%>
<%--     <pm:date pattern="yyyy-MM-dd hh:mm:ss" />  <br>     --%>
<%--     </pm:loop>  --%>
    <pm:skipTag/>
    页面元素内容
</body>
</html>