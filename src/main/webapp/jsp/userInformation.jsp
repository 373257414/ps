<%@ page language="java" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html lang="en">
  <head>
    <base href="<%=basePath%>">
    
    <title>北京邮电大学|图片档案馆|个人信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <link rel="stylesheet" href="css/userInformation.css" media="screen">
    <link rel="stylesheet" href="css/reset.css" media="screen">
    <script src="js/jquery-2.2.4.js" type="text/javascript"></script>
  </head>
  
  <body>
 	<div id="container">
 		<header>
 			<h1>个人信息</h1>
 		</header>
 		<div id="mainSection">
		 	<div>
				<table width="350" height="200" align="center" border="1">
					<tbody align="center">
						<tr>
							<td>用户名</td>
							<td>ZHY &nbsp&nbsp&nbsp&nbsp<a id="pwdChange" href="#">修改登录密码</a></td>
						</tr>
						<tr>
							<td>电子邮箱</td>
							<td>kirazhy@sina.com &nbsp&nbsp&nbsp&nbsp<a id="emailChange" href="#">修改电子邮箱</a></td>
						</tr>
						<tr>
							<td>所属部门</td>
							<td>学生</td>
						</tr>
						<tr>
							<td>所属权限</td>
							<td>普通用户</td>
						</tr>			
					</tbody>
				</table>
		 	</div>
		 	<div id="pwdChangeSection">
			 	<form name="pwdChange"> 
			 		<div id="password" class="textInput">
				 		<p>
					 		<label for="oldPassword">请输入当前密码：</label>
					 		<input type="password" id="oldPassword" size="25" placeholder="your old password"/>
				 		</p>
				 		<p>
					 		<label for="newPassword1">请输入新密码：</label>
					 		<input type="password" id="newPassword1" size="25" placeholder="your new password"/>
				 		</p>
				 		<p>
					 		<label for="newPassword2">请再次输入新密码：</label>
					 		<input type="password" id="newPassword2" size="25" placeholder="your new password again"/>
				 		</p>
			 		</div>
			 		<div id="btnForPwd" class="buttons">
			 			<input type="submit" value="确认更改" name="sendBtn"/>
			 			<input type="reset" value="全部清空" name="resetBtn" class="resetBtn"/>
			 		</div>
			 	</form>
		 	</div>
		 	<div id="emailChangeSection">
		 		<form id="emailChange">
		 			<div id="email" class="textInput">
		 				<p>
		 					<label for="userName">请输入当前用户名：</label>
		 					<input type="text" id="userName" size="25" placeholder="your username"/>
		 				</p>
		 				<p>
		 					<label for="pwdForEmail">请输入当前密码：</label>
		 					<input type="password" id="pwdForEmail" size="25" placeholder="your password"/>
		 				</p>
		 				<p>
		 					<label for="newEmail">请输入新邮箱地址：</label>
		 					<input type="text" id="newEmail" size="25" placeholder="new email address"/>
		 				</p>
		 			</div>
		 			<div id="btnForEmail" class="buttons">
		 				<input type="submit" value="确认更改" name="sendBtn"/>
		 				<input type="reset" value="全部清空" name="resetBtn" class="resetBtn"/>
		 			</div>
		 		</form>
		 	</div>
	 	</div>
 	</div>
 	<script src="js/userInfoChange.js" charset="gbk"></script>
  </body>
</html>
