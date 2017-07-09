<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bootstrap 实例 - 页面标题</title>
   <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
   <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
   <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
   <script>
   $(document).ready(function(){
    alert("页面标题实例");
    $("#btn").click(function(){
        $.post("getPerson",{name:$("#name").val()},function(data){
             alert(data);
         });
     });
   });
   
   function ceshi() //默认禁止的就不需要选中了 
   {
    var checkbox = $("#ce").find("input:checkbox:not([disabled])");
    checkbox.attr("checked",true);
	
   }
</script>

</head>
<body>
<div class="page-header">
   <h1>页面标题实例
      <small>子标题</small>
   </h1>
</div>
<button  type="button"  id="btn">默认</button>
<button  type="button" onclick="ceshi()" id="btn">默认禁止的就不需要选中了 &#187;</button>
<p>这是一个示例文本。这是一个示例文本。</p>
<input id="name">
<div id="ce">
    <input type="checkbox" name="newsletter" value="Daily" disabled />Dairy
    <input type="checkbox" name="newsletter" value="Weekly" />Weekly
    <input type="checkbox" name="newsletter" value="Monthly" />Monthly
</div>
2asas
<form action="upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file"><br>
    <input type="submit" value="submit">
</form>
</body>
</html>