<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户登录页面</title>
<link rel="stylesheet" href="css/global_style.css" type="text/css" />
<script type="text/javascript">

	window.onload = function(){
		
		var user = document.getElementById("user");
		var pass = document.getElementById("pass");
		
		document.forms[0].onsubmit = function(){

				var login_error = document.getElementById("login_error");
				
				if(!user.value){
					login_error.innerHTML = "请输入用户名";
					return false;
				}
				
				if(!pass.value){
					login_error.innerHTML = "请输入密码";
					return false;
				}
					
					//onfocus  onblur
		}
		
		var sp1 = document.getElementById("sp1");
		var sp2 = document.getElementById("sp2");
		
		user.onfocus = function(){
			sp1.style.display = "none";
		}
		user.onblur = function(){
			if(!user.value){
				sp1.style.display = "block";
			}
		}
		
		pass.onfocus = function(){
			sp2.style.display = "none";
		}
		pass.onblur = function(){
			if(!pass.value){
				sp2.style.display = "block";
			}
		}
		
		sp1.onclick = function() {
			user.focus();
		}
		sp2.onclick = function() {
			user.focus();
		}	
	}

</script>
</head>
<body style="background-color:#16aabd; ">
	<div class="login_all">
	  	<div class="login_all_content">
			<div class="login_head">
				<h1>英雄联盟活动登录入口</h1>
			</div>
			<div class="login_center">
			<form action="login.do" method="post" id="login_form">
				<div class="login_center_content">
					<div class="login_name">
						<label>用户名：</label>
						<div class="password_text">
							<span class="write_word"  id="sp1">请输入用户名</span>
							<input type="text"  name="user" id="user"/>
						</div>
						<div class="clr"></div>
					</div>
					<div class="login_error" id="login_error">
						<%= request.getAttribute("error") %>
					</div>
					<div class="password_name">
						<label>密码：</label>
						<div class="password_text">
							<span class="write_word"  id="sp2">请输入密码</span>
							<input type="password"  name="pass"  id="pass"/>
						</div>
						<div class="clr"></div>
					</div>
					<input type="submit" class="login_button" value="&nbsp;"/>
				</div>	
				</form>
			</div><!--login_center-->
			<div class="login_bottom"></div>		
		</div><!--login_all_content-->
	</div><!--login_all-->
</body>
</html>