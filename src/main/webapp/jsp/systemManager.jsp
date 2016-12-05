<%@ page language="java" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html lang="en">
  <head>
    <base href="<%=basePath%>">
    
    <title>北京邮电大学|图片档案馆|系统管理员</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <link rel="stylesheet" href="css/reset.css" media="screen">
    <link rel="stylesheet" href="css/buttons.css" media="screen"/>
    <link rel="stylesheet" href="css/mainFrame.css" media="screen">
    <script src="js/jquery-2.2.4.js" type="text/javascript"></script>
    <script src="js/advancedSearch.js" type="text/javascript" charset="gbk"></script>
    <script src="js/slideToggle.js" type="text/javascript"></script>"

  </head>
  
  <body>
 	<div id="container">
        <header>
            <img src="img/topbackground.jpg" align="middle" alt="北京邮电大学照片档案管理系统" id="topBackground">
            <nav id="navBar">
                <ul>
                    <li><a href="jsp/systemAdmin.jsp" title="首页">首页</a></li>
                    <li><a href="#" title="人气排行">人气排行</a></li>
                </ul>
            </nav>
        </header>
        <div id="mainSection">
            <div id="leftSection">
            	<header class="leftHeader">
                	<a href="#" class="lHeader">用户信息</a>
                </header>
                <div id="userSection" class="firstSection">
                	<div id="information">
	                	<p>欢迎：<a href="jsp/userInformation.jsp" target="main">${sessionScope.userName}</a></p>
	                	<p>权限：系统管理员</p>
	                	<p><a href="jsp/userInformation.jsp" target="main" class="button button-glow button-border button-rounded button-tiny button-primary"/>查看</a></p>
                	</div>
                	<a href="jsp/login.jsp" id="logout"><img src="img/ZHYlogout32.png" alt="注销" title="注销"/></a>
                </div>
                <header class="leftHeader">
	                <a href="#" class="lHeader">图片搜索</a>
	            </header>
                <div id="searchSection">
	                <form id="Q_searchForm">
	                	<div id="Q_inputSec">
		                	<select name="searchKeys" size="1" id="searchKeys">
			                    <option value="fileNumber" select="selected">档案号</option>
			                    <option value="pictrueIntro">图片说明</option>
			                    <option value="importantPerson">关键人物</option>
			                    <option value="photogragher">摄影者</option>
			                    <option value="placeOfTaken">拍摄地点</option>
			                    <option value="fileDepartment">归档部门</option>
			                    <option value="pictrueKind">图片种类</option>
		                    </select>
		                    <input type="text" name="keywords" required="required"/>
	                	</div>
		                <div id="Q_searchBtn">
			                <input type="submit" value="搜索" name="search" class="button button-3d button-action button-pill button-tiny"/>
	                		<input type="reset" value="清空" name="reset" class="button button-3d button-caution button-pill button-tiny"/>
		                </div>
	                </form>
	                <a href="#" title="高级搜索" id="A_Search_link"><img src="img/ZHYgodown16.png" class="icon_inline icon_change_search"/>高级搜索<img src="img/ZHYgodown16.png" class="icon_inline icon_change_search"/></a>
	                <div id="A_SearchSection">
	                	<form id="A_searchForm">
		                	<div id="A_inputSec">
		                        <p>
		                            <label for="fileNumber">归档号码</label>
		                            <input type="text" id="fileNumber" name="fileNumber" size="15" maxlength="20"/>
		                        </p>
		                        <p>
		                            <label for="pictureIntro">图片说明</label>
		                            <input type="text" id="pictureIntro" name="pictureIntro" size="15" maxlength="20"/>
		                        </p>
		                        <p>
		                            <label for="importantPerson">关键人物</label>
		                            <input type="text" id="importantPerson" name="importantPerson" size="15" maxlength="20"/>
		                        </p>
		                        <p>
		                            <label for="photographer">摄影人员</label>
		                            <input type="text" id="photographer" name="photographer" size="15" maxlength="20"/>
		                        </p>
		                        <p>
		                            <label for="placeOfTaken">拍摄地点</label>
		                            <input type="text" id="placeOfTaken" name="placeOfTaken" size="15" maxlength="20"/>
		                        </p>
		                        <p>
		                            <label for="fileDepartment">归档部门</label>
		                            <input type="text" id="fileDepartment" name="fileDepartment" size="15" maxlength="20"/>
		                        </p>
		                        <p>
		                            <label for="pictureKind">图片种类</label>
		                            <input type="text" id="pictureKind" name="pictureKind" size="15" maxlength="20"/>
		                        </p>
		                    </div>
		                    <div id="A_check">
		                        <input type="radio" value="accurateSearch" name="check" title="照片符合所有选择条件" checked="check"/>精确搜索
		                        <input type="radio" value="blurySearch" name="check" title="照片符合任意一个选择条件即可"/>模糊搜索
		                    </div>
		                    <div id="A_searchBtn">
		                        <input type="submit" value="搜索" name="resetButton" class="button button-3d button-action button-pill button-tiny"/>
		                        <input type="reset" value="清空" name="search" class="button button-3d button-caution button-pill button-tiny"/>
		                    </div>
	                	</form>
	                </div>
                </div>
                <header class="leftHeader">
                	<a href="#" class="lHeader">用户功能</a>
                </header>
                <div id="functions">
                    <ul type="none">
                        <li><a href="jsp/classifyScan.jsp" target="main" title="分类浏览">分类浏览</a></li>
                        <li><a href="#" target="main" title="下载照片-系统管理员">下载照片</a></li>
                        <li><a href="jsp/depManage.jsp" target="main" title="部门管理">部门管理</a></li>
                        <li><a href="#" target="main" title="照片类别管理">照片类别管理</a></li>
                        <li><a href="jsp/userManage.jsp" target="main" title="用户管理">用户管理</a></li>
                        <li><a href="#" target="main" title="图片管理">图片管理</a></li>
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
