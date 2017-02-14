<%@ page language="java" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html lang="en">
  <head>
    <base href="<%=basePath%>">
    
    <title>北京邮电大学|图片档案馆|游客登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <link rel="stylesheet" href="css/passerbyMain.css" media="screen">
    <link rel="stylesheet" href="css/reset.css" media="screen">

  </head>
  
  <body>
    <div id="container">
        <header>
            <img src="img/topbackground.jpg" align="middle" alt="北京邮电大学照片档案管理系统" id="topBackground">
            <nav id="navBar">
                <ul>
                    <li><a href="jsp/test.jsp" title="首页">首页</a></li>
                    <li><a href="#" title="人气排行">人气排行</a></li>
                </ul>
            </nav>
        </header>
        <div id="mainSection">
            <div id="leftSection">
                <div id="welcome">
                    <h1>欢迎：ZHY(passerby)</h1>
                    <a href="jsp/login.jsp" title="注销">注销</a>
                </div>
                <div id="functions">
                    <ul type="none">
                        <li><a href="jsp/quickSearch.jsp" target="main" title="快速搜索">快速搜索</a></li>
                        <li><a href="jsp/advancedSearch.jsp" target="main" title="高级搜索">高级搜索</a></li>
                        <li><a href="jsp/classifyScan.jsp" target="main" title="分类浏览">分类浏览</a></li>
                    </ul>
                </div>
            </div>
            <div id="rightSection">
                <iframe src="jsp/quickSearch.jsp" name="main" allowtransparency="true" scrolling="no" frameborder="0" marginwidth="0" marginheight="0">
                </iframe>
            </div> 
        </div>
        <footer><address>Beijing University of Posts and Telecommunications 2016 Photo Album</address></footer>
    </div>
  </body>
</html>
