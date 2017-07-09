<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在Servlet3.0中上传文件变得非常简单</title>
</head>
<body>

<form method="post" action="servlet/upload" enctype="multipart/form-data">  
   <input type="file" name="upload"/>  
   <input type="submit" value="upload"/>  
</form> 
</body>
</html>