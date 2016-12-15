<%@ page language="java" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html lang="en">
  <head>
    <base href="<%=basePath%>">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8"/>
    <title>北京邮电大学|图片档案馆|游客登录|分类浏览</title>
	<link rel="stylesheet" href="css/classifyScan.css" media="screen">
    <link rel="stylesheet" href="css/reset.css" media="screen">

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
<body>
    <div id="container">
        <header>
            <h1>分类浏览</h1>
        </header>
        <div id="classSection">
            <ul>
                <li><a href="#" target="Scan" title="毕业生合影">毕业生合影</a></li>
                <li><a href="#" target="Scan" title="校园建设及风光">校园建设及风光</a></li>
                <li><a href="#" target="Scan" title="教工活动">教工活动</a></li>
                <li><a href="#" target="Scan" title="领导视察">领导视察</a></li>
                <li><a href="#" target="Scan" title="严谨学风">严谨学风</a></li>
            </ul>
        </div>
        <div id="scanSection">
            <table align="center">
                <tr>
                    <td>
                        <img src="img/logo.gif">
                        <p>简要信息</p>
                    </td>
                    <td>
                        <img src="img/logo.gif">
                        <p>简要信息</p>
                    </td>
                </tr>
                <tr>
                    <td>
                        <img src="img/logo.gif">
                        <p>简要信息</p>
                    </td>
                    <td>
                        <img src="img/logo.gif">
                        <p>简要信息</p>
                    </td>
                </tr>
                <tr>
                    <td>
                        <img src="img/logo.gif">
                        <p>简要信息</p>
                    </td>
                    <td>
                        <img src="img/logo.gif">
                        <p>简要信息</p>
                    </td>
                </tr>
            </table>
            <br/>
            <div id="page">
                <p>
                    <a onclick="test()" href="#">首页</a> 
                    <a onclick="test()" href="#">上一页</a>
                    <a onclick="test()" href="#">下一页</a> 
                    <a onclick="test()" href="#">尾页</a> 
					跳转到第
                    <select>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                        <option>6</option>
                    </select>
                   	 页
                </p>
            </div>
        </div>
    </div>
</body>
</html>
