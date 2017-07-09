<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.pmqin.cn" prefix="jxf"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>模仿c标签库的choose，when，otherwise</title>
</head>
<body>
<%--  <jxf:demoTag>标签体内容</jxf:demoTag> --%>
     标签体余下内容
    <br />
    <jxf:chooseTag> 
        <jxf:whenTag test="${4>5}">
            4>5是不输出的 
        </jxf:whenTag>
        <jxf:whenTag test="${10>5}">
            10>5是成立的
        </jxf:whenTag>
        <jxf:whenTag test="${9>5}">
            9>5是成立的,但是不输出
        </jxf:whenTag>
        <jxf:otherwiseTag>
                          当条件都不成立时候输出（由于第二个提条件成立，故不应输出）
        </jxf:otherwiseTag>
    </jxf:chooseTag>
</body>
</html>