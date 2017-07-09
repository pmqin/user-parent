<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.pmqin.com" prefix="pmqin"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>简单标签</title>
</head>
<body>
 <pmqin:demo1>eqweqweqw </pmqin:demo1>
 <br>
	 <pmqin:demo2>demo2 </pmqin:demo2>  <br>
            您好 ,简单标签
    <pmqin:skipJsp/>
    这个没有显示了  由于有pmqin:skipJsp
</body>
</html>