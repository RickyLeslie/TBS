<%@ page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="../H-ui.admin/lib/html5shiv.js"></script>
<script type="text/javascript" src="../H-ui.admin/lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="../H-ui.admin/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="../H-ui.admin/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="../H-ui.admin/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="../H-ui.admin/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="../H-ui.admin/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="../H-ui.admin/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>用户管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 用户中心 <span class="c-gray en">&gt;</span> 用户管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c">
		<input type="text" class="input-text" style="width:250px" placeholder="输入会员名称、电话、邮箱" id="" name="">
		<button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜用户</button>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> 
		<a href="javascript:;" onclick="member_add('添加用户','${pageContext.request.contextPath}/jsps/customer-add.jsp','','510')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加用户</a>
		<a href="javascript:;" onclick="member_add('导入Excel文件','${pageContext.request.contextPath}/jsps/customer-excel.jsp','','510')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 导入Excel文件</a>
		<a href="${pageContext.request.contextPath}/acc/excelWrite" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe644;</i> 导出Excel文件</a></span>
		<span class="r">共有数据：<strong>${pageBean.allRow}</strong> 条</span> </div>
	<div class="mt-20">
	<div>显示
		<select id="pageSize">
			<option value="10">10</option>
			<option value="${pageContext.request.contextPath}/acc/pageQuery?currentPage=1&pageSize=5">50</option>
			<option value="100">100</option>
		</select>
	条</div><br/>
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="50"><input type="checkbox" id="allSelect" value=""></th>
				<th width="150">ID</th>
				<th width="150">客户名</th>
				<th width="150">客户类型</th>
				<th width="150">地址</th>
				<th width="100">经理</th>
				<th width="100">行业</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.pageBean.list}" var="customer">
			<tr class="text-c">
				<td><input type="checkbox" value="{customer.id}" name="" id="id"></td>
				<td>${customer.id}</td>
				<td>${customer.customerName}</td>
				<td><u style="cursor:pointer" class="text-primary" onclick="">${customer.customerType}</u></td>
				<td>${customer.location}</td>
				<td>${customer.manager}</td>
				<td>${customer.industry}</td>
				<td class="td-status"><span class="label label-success radius">已启用</span></td>
				<td class="td-manage"><a style="text-decoration:none" onClick="member_stop(this,'10001')" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a> 
					<a title="编辑" href="javascript:;" onclick="member_edit('编辑','${pageContext.request.contextPath}/cus/update?id=${customer.id }','4','','510')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> 
					<a title="删除" href="javascript:;" onclick="member_del(this,'${customer.id}')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<br/>
	<div>
		<div style="float:left">共&nbsp;&nbsp;${pageBean.totalPage}&nbsp;&nbsp;页</div>
		<div style="float: right">
			<a id="prePageA" href="${pageContext.request.contextPath}/cus/pageQuery?currentPage=${pageBean.currentPage-1}&pageSize=${pageBean.pageSize}" ><button id="prePage" class="btn btn-secondary-outline radius">上一页</button></a>
			<label id="currentPage" value="${pageBean.currentPage}">${pageBean.currentPage}</label>
			<a id="nextPageA" href="${pageContext.request.contextPath}/cus/pageQuery?currentPage=${pageBean.currentPage+1}&pageSize=${pageBean.pageSize}" ><button id="nextPage" class="btn btn-secondary-outline radius">下一页</button></a>
		</div>
	</div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="../H-ui.admin/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="../H-ui.admin/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../H-ui.admin/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="../H-ui.admin/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="../H-ui.admin/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="../H-ui.admin/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="../H-ui.admin/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
/*判断是否存在上下页*/
$(document).ready(function (){
	if($('#currentPage').text()==1){
		$("#prePageA").click(function(){
	 		return false;
	 	}) 
		$('#prePage').prop('class','btn disabled radius');
	}
	if($('#currentPage').text()=="${pageBean.totalPage}"){
		$("#nextPageA").click(function(){
	 		return false;
	 	})
		$('#nextPage').prop('class','btn disabled radius');
	}
})

/*每页记录数*/
function pageSizeChange(){
	var pageSize=document.getElementById("pageSize");
	if(pageSize.selectedIndex==0){
	}
	if(pageSize.selectedIndex==1){
	}
	if(pageSize.selectedIndex==2){
	}
}
var isFirstPage=document.getElementById("nextPage");
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*导出Excel文件*/
/*function member_execlWrite(title,url,w,h){
	layer_show(title,url,w,h);
}*/
/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*用户-停用*/
function member_stop(obj,id){
	layer.confirm('确认要停用吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '',
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a>');
				$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
				$(obj).remove();
				layer.msg('已停用!',{icon: 5,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}

/*用户-启用*/
function member_start(obj,id){
	layer.confirm('确认要启用吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '',
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>');
				$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
				$(obj).remove();
				layer.msg('已启用!',{icon: 6,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});
	});
}
/*用户-编辑*/
function member_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*密码-修改*/
function change_password(title,url,id,w,h){
	layer_show(title,url,w,h);	
}
/*用户-删除*/
function member_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '${pageContext.request.contextPath}/cus/delete?id='+id,
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").remove();
				layer.msg('已删除!',{icon:1,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}
/*批量删除*/
function batchDelete(){
	 layer.confirm('确认要删除吗？',function(index){  
    // 获取所有选中的checked框  
    var option = $(":checked");  
    var checkedId = "";  
    var boo=true;  
    //拼接除全选框外,所有选中的id,  
    for (var i = 0, len = option.length; i < len; i++) {  
        if (boo) {  
            if (option[i].id=='allSelect') {  
                boo=true;  
            }else {  
                boo=false;  
                checkedId += option[i].value;  
            }  
        }else{  
            checkedId += ","+option[i].value;  
        }  
    }  
     $.ajax({  
              type: "post",  
              url:'${pageContext.request.contextPath}/cus/batchDelete',  
              data : {  
              "checkedId":checkedId  
              },  
              dataType:"json",  
              success : function(map) {  
                 parent.layer.msg(map.message,{icon: 6,time:1000});  
                 setTimeout("serachFromSubmit()", 1000);  
              },error:function(code){   
                     parent.layer.msg('操作失败!',{icon: 5,time:1000});  
              }   
            });  
    });
}
</script> 
</body>
</html>