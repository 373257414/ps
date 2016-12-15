<%@ page language="java" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<title>主页</title>
	<script type="text/javascript" src="..\js\test.js"></script>

	<style type="text/css">
	.beijing{
		/*background-color: #ffffff;*/
		background: rgba(255,255,255,0.7) none repeat 0 0 !important;
		/*filter:alpha(opacity=50);/*ie**/
		/*opacity: 0.5;*/
	}
	.beijing h1{
		font-family: 微软雅黑;
		font-weight: normal;
		/*position: relative;*/
		/*color: #000000;*/
	}
	a{
		text-decoration: none;
		color: #000000;
		font-family: 微软雅黑;
	}
	a:hover{
		color: #00a1f1;
	}
	</style>
</head>

<body class="beijing">
	<h1 align="center">北京邮电大学图片档案馆欢迎您！</h1>
	<table align="center">
		<tr>
			<td>
				<img src="img\logo.gif" width="250px">
				图片描述
			</td>
			<td>
				<img src="img\logo.gif" width="250px">
				图片描述
			</td>
		</tr>
		<tr>
			<td>
				<img src="img\logo.gif" width="250px">
				图片描述
			</td>
			<td>
				<img src="img\logo.gif" width="250px">
				图片描述
			</td>
		</tr>
		<tr>
			<td>
				<img src="img\logo.gif" width="250px">
				图片描述
			</td>
			<td>
				<img src="img\logo.gif" width="250px">
				图片描述
			</td>
		</tr>
		<tr>
			<td>
				<img src="img\logo.gif" width="250px">
				图片描述
			</td>
			<td>
				<img src="img\logo.gif" width="250px">
				图片描述
			</td>
		</tr>
		<tr>
			<td>
				<img src="img\logo.gif" width="250px">
				图片描述
			</td>
			<td>
				<img src="img\logo.gif" width="250px">
				图片描述
			</td>
		</tr>
	</table>
	<div align="center">
		<p>
			<a onclick="test()" href="#">首页</a> <a onclick="test()" href="#">上一页</a> <a onclick="test()" href="#">下一页</a> <a onclick="test()" href="#">尾页</a> 跳转到第<select>
			<option>1</option>
			<option>2</option>
			<option>3</option>
			<option>4</option>
			<option>5</option>
		</select>页
		</p>
	</div>
</body>
</html>