<%@ page language="java" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html lang="en">
  <head>
    <base href="<%=basePath%>">
    
    <title>北京邮电大学|图片档案馆|普通用户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <link rel="stylesheet" href="css/mainFrame.css" media="screen">
    <link rel="stylesheet" href="css/buttons.css" media="screen"/>
    <link rel="stylesheet" href="css/reset.css" media="screen">
    <script src="js/jquery-2.2.4.js" type="text/javascript"></script>

  </head>
  
  <body>
	<div id="container">
        <header>
            <img src="img/topbackground.jpg" align="middle" alt="北京邮电大学照片档案管理系统" id="topBackground">
            <nav id="navBar">
                <ul>
                    <li><a href="jsp/normalUser.jsp" title="首页">首页</a></li>
                    <li><a href="#" title="人气排行">人气排行</a></li>
                </ul>
            </nav>
        </header>
        <div id="mainSection">
            <div id="leftSection">
                <div id="userSection">
                	<header class="leftHeader">
                		<p>用户信息</p>
                	</header>
                	<div id="information">
	                	<p>欢迎：<a href="jsp/userInformation.jsp" target="main">${sessionScope.userName}</a></p>
	                	<p>权限：普通用户</p>
	                	<p><a href="jsp/userInformation.jsp" target="main" class="button button-glow button-border button-rounded button-tiny button-primary"/>查看</a></p>
                	</div>
                	<a href="jsp/login.jsp" id="logout"><img src="img/ZHYlogout32.png" alt="注销" title="注销"/></a>
                </div>
                <div id="searchSection">
	                <header class="leftHeader">
	                	<p>图片搜索</p>
	                </header>
	                <form id="searchForm">
	                	<div id="inputSec">
		                	<select name="searchKeys" size="1" id="searchKeys">
			                    <option value="fileNumber" select="selected">档案号</option>
			                    <option value="pictrueIntro">图片说明</option>
			                    <option value="importantPerson">关键人物</option>
			                    <option value="photogragher">摄影者</option>
			                    <option value="placeOfTaken">拍摄地点</option>
			                    <option value="fileDepartment">归档部门</option>
			                    <option value="pictrueKind">图片种类</option>
			                    <option value="dayFrom">起始日期</option>
			                	<option value="dayTo">终止日期</option>
		                    </select>
		                    <input type="text" name="keywords" id="keywords" placeholder="请输入关键词" size="15" maxlength="25" required="required"/>
	                	</div>
		                <div id="searchBtn">
			                <input type="submit" value="搜索" name="search" class="button button-3d button-action button-pill button-tiny"/>
	                		<input type="reset" value="清空" name="reset" class="button button-3d button-caution button-pill button-tiny"/>
		                </div>
	                </form>
	                <a href="jsp/advancedSearch.jsp" target="main" title="高级搜索">高级搜索</a>
                </div>
                <div id="functions">
                	<header class="leftHeader">
                		<p>功能权限</p>
                	</header>
                    <ul type="none">
                        <li><a href="jsp/classifyScan.jsp" target="main" title="分类浏览">分类浏览</a></li>
                        <li><a href="#" target="main" title="下载照片-普通用户">下载照片</a></li>
                        <li><a href="#" target="main" title="照片征集">照片征集</a></li>
                    </ul>
                </div>
            </div>
            <div id="rightSection">
                <iframe src="#" name="main" allowtransparency="true" scrolling="no" frameborder="0" marginwidth="0" marginheight="0">
                </iframe>
            </div> 
        </div>
        <footer><address>Beijing University of Posts and Telecommunications 2016 Photo Album</address></footer>
    </div>
  </body>
</html>
