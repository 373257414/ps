<%@ page language="java" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html lang="en">
  <head>
    <base href="<%=basePath%>">
    
    <title>北京邮电大学|图片档案馆|系统管理员|部门管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <link rel="stylesheet" href="css/depManage.css" media="screen">
    <link rel="stylesheet" href="css/reset.css" media="screen">
    <script src="js/jquery-2.2.4.js" type="text/javascript"></script>

  </head>
  
  <body>
    <div id="container">
    	<header>
    		<h1>部门管理</h1>
    	</header>
    	<div id="mainSection">
    		<div id="leftSection">
	    		<select multiple id="departments" size="20">
	    			<option value="1">教务处</option>
	    			<option value="2">教导处</option>
	    			<option value="3">教学处</option>
	    			<option value="4">学生会</option>
	    			<option value="5">信通院</option>
	    		</select>
	    		<div id="LeftBtn" class="buttons">
		    		<input type="button" value="编辑部门" id="editDepBtn" name="editDepBtn"/>
		    		<input type="button" value="添加部门" name="insertDepBtn"/>
		    		<input type="button" value="删除部门" name="deleteDepBtn"/>
	    		</div>
    		</div>
    		<div id="rightSection">
    			<div id="depInfo">
	    			<p>
	    				<label for="depId">部门编号：</label>
	    				<input type="text" id="depId" size="20" readonly/>
	    			</p>
	    			<p>
	    				<label for="depName">部门名称：</label>
	    				<input type="text" id="depName" size="20" readonly/>
	    			</p>
	    			<P>
	    				<label for="depTel">部门电话：</label>
	    				<input type="text" id="depTel" size="20" readonly/>
	    			</p>
	    			<p>
	    				<label for="depAddr">部门地址：</label>
	    				<input type="text" id="depAddr" size="20" readonly/>
	    			</p>	
    			</div>
    			<div id="depEdit">
    				<form>
    					<p>
    						<label for="editDepId">请输入用户名：</label>
    						<input type="text" id="editDepId" size="20" placeholder="department ID"/>
    					</p>
    					<P>
    						<label for="editDepName">请输入部门名称：</label>
    						<input type="text" id="editDepName" size="20" placeholder="department name"/>
    					</P>
    					<p>
    						<label for="editDepTel">请输入部门电话：</label>
    						<input type="text" id="editDepTel" size="20" placeholder="department tel"/>
    					</p>
    					<p>
    						<label for="editDepAddr">请输入部门地址：</label>
    						<input type="text" id="editDepAddr" size="20" placeholder="department address"/>
    					</p>
    					<div class="buttons" id="rightBtn">
    						<input type="submit" value="确认提交" id="submitBtn" name="submitBtn"/>
    						<input type="reset" value="全部清空" id="resetBtn" name="resetBtn"/>
    					</div>
    				</form>
    			</div>
    		</div>
    	</div>
    </div>
    <script src="js/depManagement.js" charset="gbk"></script>
  </body>
</html>
