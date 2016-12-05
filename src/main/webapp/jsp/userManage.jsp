<%@ page language="java" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html lang="en">
  <head>
    <base href="<%=basePath%>">
    
    <title>北京邮电大学|系统管理员|用户管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/reset.css" media="screen">
	<link rel="stylesheet" href="css/buttons.css" media="screen">
	<link rel="stylesheet" href="css/userManage.css" media="screen">
	<script src="js/jquery-2.2.4.js" type="text/javascript"></script>
	<script src="js/userManage.js" type="text/javascript" charset="gbk"></script>

  </head>
  
  <body>
    <div id="container">
    	<header>
 			<h1>用户管理</h1>
 		</header>
 		<div id="mainSection">
 			<div id="leftSection">
	    		<select multiple id="users" size="28">
	    			<option value="1">刘润泽</option>
	    			<option value="2">张华一</option>
	    			<option value="3">王敏</option>
	    		</select>
	    		<div id="LeftBtn" class="buttons">
		    		<button  name="editUserBtn" id="editUserBtn" class="button button-raised button-action button-pill button-small">编辑用户</button>
		    		<button  name="addUserBtn" id="addUserBtn" class="button button-raised button-highlight button-pill button-small">添加用户</button>
		    		<button  name="deleteUserBtn" class="button button-raised button-caution button-pill button-small">删除用户</button>
	    		</div>
    		</div>
    		<div id="rightSection">
    			<div id="userInfo">
    				<h2>用户信息</h2>
	    			<p>
	    				<label for="info_username">用户名称</label>
	    				<input type="text" id="info_username" size="20" readonly/>
	    			</p>
	    			<p>
	    				<label for="info_password">用户密码</label>
	    				<input type="text" id="info_password" size="20" readonly/>
	    			</p>
	    			<P>
	    				<label for="info_department">用户部门</label>
	    				<input type="text" id="info_department" size="20" readonly/>
	    			</p>
	    			<p>
	    				<label for="info_permission">用户权限</label>
	    				<input type="text" id="info_permission" size="20" readonly/>
	    			</p>	
    			</div>
    			<div id="userEdit">
    				<h2>添加用户</h2>
    				<form id="editForm" action="addUserAction" method="post" enctype="application/x-www-form-urlencoded">
    					<p>
    						<label for="edit_username">输入用户名</label>
    						<input type="text" id="edit_username" name="userName" class="username" size="20"/>
    					</p>
    					<P>
    						<label for="edit_password">输入密码</label>
    						<input type="text" id="edit_password" name="password" class="password" size="20"/>
    					</P>
    					<p>
    						<label for="edit_departmentId">输入用户部门</label>
    						<select id="edit_departmentId" name="departmentId" size="1">
    							<option value="">--请选择--</option>
    							<option value="1">部门1</option>
    							<option value="2">部门2</option>
    							<option value="3">部门3</option>
    						</select>
    					</p>
    					<p>
    						<label for="edit_permissionId">输入用户权限</label>
    						<select id="edit_permissionId" name="permissionId" size="1">
    							<option value="">--请选择--</option>
    							<option value="3">普通用户</option>
    							<option value="2">部门管理员</option>
    							<option value="1">系统管理员</option>
    						</select>
    					</p>
    					<div class="buttons" id="editBtn">
    						<input type="button" value="提交" id="submitBtn" name="submitBtn" class="button button-3d button-action button-pill button-tiny"/>
    						<input type="reset" value="清空" id="resetBtn" name="resetBtn" class="button button-3d button-caution button-pill button-tiny"/>
    					</div>
    				</form>
    			</div>
    		</div>
 		</div>
    </div>
  </body>
</html>
