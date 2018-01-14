<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>login</title>
<link rel="stylesheet" type="text/css" href="css/normalize.css" tppabs="http://www.17sucai.com/preview/668095/2017-07-19/perfect/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" tppabs="http://www.17sucai.com/preview/668095/2017-07-19/perfect/css/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="css/component.css" tppabs="http://www.17sucai.com/preview/668095/2017-07-19/perfect/css/component.css" />
<!--[if IE]>
<script src="js/html5.js"></script>
<![endif]-->
</head>
<body>
		<div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">
						<h3>欢迎你</h3>
						<form action="login/phone" name="f" method="post" id="form">
							<div class="input_outer">
								<span class="u_user"></span>
								<input name="username" id="username" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input name="password" id="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
							</div>
							<div class="mb2"><a id="login" class="act-but submit" style="color: #FFFFFF">登陆</a></div>
							<div class="mb2"><a href="login.jsp" class="act-but submit" style="color: #FFFFFF">管理员登陆</a></div>
						</form>
					</div>
				</div>
			</div>
		</div><!-- /container -->
		<script src="js/TweenLite.min.js" tppabs="http://www.17sucai.com/preview/668095/2017-07-19/perfect/js/TweenLite.min.js"></script>
		<script src="js/EasePack.min.js" tppabs="http://www.17sucai.com/preview/668095/2017-07-19/perfect/js/EasePack.min.js"></script>
		<script src="js/rAF.js" tppabs="http://www.17sucai.com/preview/668095/2017-07-19/perfect/js/rAF.js"></script>
		<script src="js/demo-1.js" tppabs="http://www.17sucai.com/preview/668095/2017-07-19/perfect/js/demo-1.js"></script>
	</body>
	<script src="js/jquery-3.1.1.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		/*function login(){
			document.getElementById("login").submit();
		}*/
		$("#login").click(function () {
			$("#form").submit();
		})
		
		/*function confirm() {
			/*var id=$('input[name="id"]').val(); 
			var password=$('input[name="password"]').val();*/
			/*if(id==""||password==""){
				alert("用户名或密码不能为空");
			/*}else{
				/*$.ajax({
					type:"post",
					url:"login",
					async:false,
					data:{id:$("#id").val(),password:$("#password").val()},
					success:function(data){
						if(data==true){
							window.location.href = "home.jsp";
						}else{					
							alert("账号或密码错误！");
							form.id.focus();
						}
					}
				});
				//$("#form").submit();
			}
			
		}*/
		
		
	</script>
</html>