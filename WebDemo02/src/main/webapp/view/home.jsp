<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
	<link rel="stylesheet" href="css/global_style.css" type="text/css" />
	<script type="text/javascript">
		window.onload = function(){
			
			alert("欢迎来到英雄联盟！");
		}
	
	</script>
</head>

<body>
	<!--head-->
	<div id="head" class="main_top"> 
		 <div class="logopanel">
		 	<a>英雄联盟活动系统</a>
         </div><!--logopanel-->
		 <div class="headerpanel">
			 <div class="headerright">
			 	<p><span>用户名！</span><%=request.getAttribute("user") %>></p>
				<a class="edit_password" href="#"><img src="images/top_icon1.png" width="88" height="30" /></a>
				<a class="" href="#"><img src="images/top_icon2.png" width="88" height="30" /></a> 
				<div class="clr"></div>	
			 </div> 
			 <div class="clr"></div>
		  </div><!--headerpanel-->
		 <div class="clr"></div>	
	</div>
	<!--head结束-->	
		
	<!--main body -->
	<form action="download.action" enctype="application/x-www-form-urlencoded">
	<div style="width: 300px ; height: 300px; " >
		<img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489161016805&di=2efa1ee0856d342138e430b0d8d6fe9b&imgtype=0&src=http%3A%2F%2Fimg.taopic.com%2Fuploads%2Fallimg%2F121209%2F234928-12120Z0543764.jpg" name="download">
		<input type="submit" value="点我下载图片">
	</div>
	</form>
</body>	
</html>
