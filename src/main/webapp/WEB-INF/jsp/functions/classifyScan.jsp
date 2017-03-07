<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html lang="en">
  <head>

	<meta http-equiv="content-type" content="text/html;charset=utf-8"/>
    <title>北京邮电大学|图片档案馆|游客登录|分类浏览</title>
	<link rel="stylesheet" href="/static/css/classifyScan.css" media="screen">
    <link rel="stylesheet" href="/static/css/reset.css" media="screen">
      <script src="/static/js/jquery-2.2.4.js" type="text/javascript"></script>

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
                        <img src="/static/img/logo.gif">
                        <p>简要信息</p>
                    </td>
                    <td>
                        <img src="/static/img/logo.gif">
                        <p>简要信息</p>
                    </td>
                </tr>
                <tr>
                    <td>
                        <img src="/static/img/logo.gif">
                        <p>简要信息</p>
                    </td>
                    <td>
                        <img src="/static/img/logo.gif">
                        <p>简要信息</p>
                    </td>
                </tr>
                <tr>
                    <td>
                        <img src="/static/img/logo.gif">
                        <p>简要信息</p>
                    </td>
                    <td>
                        <img src="/static/img/logo.gif">
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
<script src="/static/js/classifyScan.js" type="text/javascript"></script>
</body>
</html>
