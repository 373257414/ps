<%@ page language="java" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>北京邮电大学照片管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <div align="center">
		<table border="0">
			<tr>
				<td colspan="2" align="center"><img src="img\top.jpg"
					style="opacity:0.8">
					<p align="left">
						<a onclick="test()" href="#">返回主页</a> 
					</p></td>
			</tr> 
		</table>
	 </div>
    <br>
    <table border=0 width=150>
    <tr>
			<td colspan="2">
				<p align="center">
					<a onclick="test()" href="#" target="main">…部门管理…  </a>
		        </p>
		     </td>
	</tr></table>
	<br>
	<table border=0 width=150>
	<tr>
			<td colspan="2"><p align="center" class="op">
			<a onclick="test()" href="#" target="main">…类别管理…</a></p>
			</td>
	</tr></table><br>
	<table border=0 width=150>
		<tr>
		 <td colspan="2">
			<p align="center">
			 <a onclick="test()" href="#">…用户登录…</a>
			</p></td>
		</tr></table><br>
		<table border=0 width=150>
		<tr>
			<td colspan="2">
				<p align="center">
				  <a onclick="test()" href="#">…图片上传…</a>
				</p></td>
		</tr></table><br>
		<table border=0 width=150>
		<tr>
			<td colspan="2">
				<p align="center">
				  <a onclick="test()" href="#">…信息添加…</a>
				</p></td>
		</tr></table><br>
		<table border=0 width=150>
		<tr>
			<td colspan="2">
				<p align="center">
				  <a onclick="test()" href="#">…图片审核…</a>
				</p></td>
		</tr></table><br>
		<table border=0 width=150>
		<tr>
			<td colspan="2">
				<p align="center">
				  <a onclick="test()" href="#">…图片修改…</a>
				</p></td>
		</tr></table><br>
		<table border=0 width=150>
		<tr>
			<td colspan="2">
				<p align="center">
				  <a onclick="test()" href="#">…图片统计…</a>
				</p></td>
		</tr></table><br>
		<table border=0 width=150>
		<tr>
			<td colspan="2">
				<p align="center">
				  <a onclick="test()" href="#">…批阅申请…</a>
				</p></td>
		</tr></table><br>
		<table border=0 width=150>
		<tr>
			<td colspan="2">
				<p align="center">
				  <a onclick="test()" href="#">…下载统计…</a>
				</p></td>
		</tr></table><br>
		<table border=0 width=150>
		<tr>
			<td colspan="2">
				<p align="center">
				  <a onclick="test()" href="#">…下载日志…</a>
				</p></td>
		</tr></table><br>
		<table border=0 width=150>
		<tr>
			<td colspan="2">
				<p align="center">
				  <a onclick="test()" href="#">…访问统计…</a>
				</p></td>
		</tr></table><br>
		<table border=0 width=150>
		<tr>
			<td colspan="2">
				<p align="center">
				  <a onclick="test()" href="#">…统计日志…</a>
				</p></td>
		</tr></table><br>
		<table border=0 width=150>
		<tr>
			<td colspan="2">
				<p align="center">
				  <a onclick="test()" href="#">…所有列表…</a>
				</p></td>
		</tr></table><br>		
  </body>
</html>
