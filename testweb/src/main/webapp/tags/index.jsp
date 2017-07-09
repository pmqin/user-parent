<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/pmqin" prefix="pm"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据类型转换</title>
</head>
<body>
	<pm:longStr longTime="1469166571000"></pm:longStr>

<%-- 	<pm:guard>  --%>
<%--         ${ param.user }, 您好fdf ，幸运密码是 oooxxx ！  --%>
<%--     </pm:guard> --%>
     <c:choose>
          <c:when test="${1>5}">
              10>5<br />
          </c:when>
          <c:when test="${6>2}">
              6>2<br />
          </c:when>
          <c:otherwise>
                           条件都不成立
          </c:otherwise>
      </c:choose>
<%--
      begin : 从哪个元素开始遍历,默认从0开始
      end    : 到哪个元素结束。默认到最后一个元素
      step     : 步长,默认1
      items    : 需要遍历的数据（集合） 
      var    : 每个元素的名称 
      varStatus: 当前正在遍历元素的状态对象。（count属性：当前位置，从1开始）
     --%>
         
<%-- <%
　　　　　
        //List数据准备
         List<Student>  list = new ArrayList<Student>();
         list.add(new Student("name001",18));
         list.add(new Student("name002",19));
         list.add(new Student("name003",20));
         pageContext.setAttribute("list",list);//放入域中
         
         //Map数据准备
         Map<String,Student> map = new HashMap<String,Student>();
         map.put("001",new Student("name001",18));
         map.put("002",new Student("name002",19));
         map.put("003",new Student("name003",20));
         pageContext.setAttribute("map",map);//放入域中
         
         //array数据准备
         Student[] array = new Student[]{
         new Student("name001",18),
         new Student("name002",19),
         new Student("name003",20)};
         pageContext.setAttribute("array",array);//放入域中
     %>
     <c:forEach var="student" begin="0" end="2" items="${list}" step="1" varStatus="varSta">
          name:${student.name}---age:${student.age}<br/>
      </c:forEach>
      遍历map
      <c:forEach var="student" begin="0" end="2" items="${map}" step="1" varStatus="varSta">
          key:${student.key}---name:${student.value.name}---age:${student.value.age}<br/>
      </c:forEach>
      遍历array
      <c:forEach var="student" begin="0" end="2" items="${array}" step="1" varStatus="varSta">
          name:${student.name}---age:${student.age}<br/>
      </c:forEach>
      一般遍历集合或者数组都是全部遍历，所以只写2个属性var和items,其他取默认值
      <c:forEach var="student" items="${array}">
          name:${student.name}---age:${student.age}<br/>
      </c:forEach> --%>



 <%--
      切割字符串，相当于split函数
      var：切割出来的每一部分字符串
      items：要切割的字符串
      delims：分割的字符，若内容为字符串，则这个字符串的每个字符都会当作一个分割的字符
      如：items="a-b-c=d=e" dilims="-=",分割的结果为 a,b,c,d,e
 --%>
   <%
		//数据准备
		String str = "a-b-c=d=e";
		pageContext.setAttribute("str", str);
	%>
	<c:forTokens var="item" items="${str}" delims="-=">
          ${item}<br />
	</c:forTokens>
</body>
</html>