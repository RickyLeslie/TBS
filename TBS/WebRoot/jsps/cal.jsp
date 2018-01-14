<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>拨打电话</title>

<script type="text/javascript" src="cal/jquery-1.8.3.min.js" tppabs="http://www.17sucai.com/preview/1/2015-06-04/phone-UI/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="cal/script.js" tppabs="http://www.17sucai.com/preview/1/2015-06-04/phone-UI/script.js"></script>

<link rel="stylesheet" type="text/css" href="cal/style.css" tppabs="http://www.17sucai.com/preview/1/2015-06-04/phone-UI/style.css">

</head>
<body>
</br></br></br>
<h1 style="text-align:center" id="time">00:00:00</h1>

<div class="nexus">
	<div class="speaker">
		<span class="circle"></span>
		<a>
			<span class="bo">拨号中·····</span>
			<span class="tong">通话中······</span>
			
		</a>
		<!-- <span class="numbers" style="font-size:12px; font-weight:normal; color:#989696;"></span> -->
	</div>
	<div class="screen">
		<div class="phone-infos">
			<button>视频</button>
			
		</div>
		
		<div class="phone-tab-contents">
		
			<div class="tab phone current">
				<div class="number-area">
					<span class="numbers" id="numbers"></span>
					<span class="phone-pic" ></span>
					<span class="over-phone">结束通话</span>
					
				</div>
				<div class="numbers-container">
					<span class="pushed1">1<!-- <em class="brd">o o</em> --></span>
					<span class="pushed2">2<!-- <em>ABC</em> --></span>
					<span class="pushed3">3<!-- <em>DEF</em> --></span>
					<span class="pushed4">4<!-- <em>GHI</em> --></span>
					<span class="pushed5">5<!-- <em>JKL</em> --></span>
					<span class="pushed6">6<!-- <em>MNO</em> --></span>
					<span class="pushed7">7<!-- <em>PQRS</em> --></span>
					<span class="pushed8">8<!-- <em>TUV</em>< --></span>
					<span class="pushed9">9<!-- <em>WXYZ</em> --></span>
					<span class="pushedasterisk fff">*</span>
					<span class="pushed0">0<!-- <em>+</em> --></span>
					<span class="pushednumber fff">#</span>
				</div>
				<p class="cover"></p>
			</div>
		</div>
		
		<ul class="main-btns">
			<li><a class="btn-people"></a></li>
			<li><a class="btn-btn" id="call"></a></li>
			<li><a class="btn-btn" style="background-position: -1px -49px;" id="hangup"></a></li>
			<li><a class="btn-del delete-btn"></a></li>
		</ul>
	</div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/H-ui.admin/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript">
		
	var hour=0;
	var minute=0;
	var second=0;
	var time=0;
	var flag;
	var clock=document.getElementById("time");
	
	function runClock () {
		time=time+1;
		second=second+1;
		if(second==60){
			second=0;
			minute=minute+1;
		}
		if(minute==60){
			minute=0;
			hour=hour+1;
		}
		clock.innerHTML=formatDigits(hour)+":"+formatDigits(minute)+":"+formatDigits(second);
	}
	
	function formatDigits (time) {
		return time<10?"0"+time:time;
	}
		
	$('#call').click(function(){
		flag=window.setInterval("runClock()",1000);
		
	})
	/*function hangUp () {
			window.clearInterval(flag);
			document.getElementById("hangUpText").innerHTML="通话结束";
			//删除a标签的子元素标签
			document.getElementById("hangUp").remove();
	}*/
	
	$('#hangup').click(function(){
		window.clearInterval(flag);
		var CUID=$('#numbers').html();
		$.ajax({
			type:"get",
			url:"${pageContext.request.contextPath}/bill/insert?CUID="+CUID+"&time="+time
		});
	})

</script>>
</html>