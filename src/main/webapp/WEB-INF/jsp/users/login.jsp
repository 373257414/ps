<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/settings/taglibs.jsp" %>

<!DOCTYPE>
<html>
  <head>
    <title>北京邮电大学|登录界面</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	<link rel="stylesheet" href="/static/css/reset.css" media="screen">
    <link rel="stylesheet" href="/static/css/buttons.css" media="screen">
    <link rel="stylesheet" href="/static/css/mainFrame.css" media="screen">
    <script src="/static/js/jquery-2.2.4.js" type="text/javascript"></script>
    <script src="https://unpkg.com/vue/dist/vue.js"></script>
  </head>
  <body>
    <div id="container">
        <header>
            <img src="/static/img/topbackground.jpg" align="middle" alt="北京邮电大学照片档案管理系统" id="topBackground">
            <nav id="navBar">
                <ul>
					<li v-for="navBar in navBars"><a :href="navBar.href" :title="navBar.title">{{navBar.title}}</a></li>
                </ul>
            </nav>
        </header>
        <div id="mainSection">
            <div id="leftSection">
            	<header class="leftHeader">
                	<a href="#" class="lHeader">用户登录</a>
                </header>
                <div id="loginSection" class="firstSection">
                	<form id="loginForm" action="/loginAction" method="post">
                		<div id="login_inputSec">
							<p v-for="loginInput in loginInputs">
								<label :for="loginInput.id"><img :src="loginInput.src" class="icon_inline label" :alt="loginInput.title" :title="loginInput.title"/></label>
								<input :type="loginInput.type" :id="loginInput.id" :class="loginInput.class" :name="loginInput.name" :placeholder="loginInput.placeholder"/>
							</p>
                		</div>
                			<button id="loginBtn" class="button button-3d button-action button-pill button-tiny">登录</button>
                	</form>
                </div>
                <header class="leftHeader">
	                <a href="#" class="lHeader">图片搜索</a>
	            </header>
                <div id="searchSection">
	                <form id="Q_searchForm">
	                	<div id="Q_inputSec">
		                	<select name="searchKeys" size="1" id="searchKeys">
								<option v-for="searchKey in searchKeys" :value="searchKey.value" :select="searchKey.select">{{searchKey.title}}</option>
		                    </select>
		                    <input type="text" name="keywords" required="required"/>
	                	</div>
		                <div id="Q_searchBtn">
			                <input type="submit" value="搜索" name="search" class="button button-3d button-action button-pill button-tiny"/>
	                		<input type="reset" value="清空" name="reset" class="button button-3d button-caution button-pill button-tiny"/>
		                </div>
	                </form>
	                <a href="#" title="高级搜索" id="A_Search_link"><img src="/static/img/ZHYgodown16.png" class="icon_inline icon_change_search"/>高级搜索<img src="/static/img/ZHYgodown16.png" class="icon_inline icon_change_search"/></a>
	                <div id="A_SearchSection">
	                	<form id="A_searchForm">
							<div id="A_inputSec">
								<p v-for="searchKey in searchKeys">
									<label :for="searchKey.value">{{searchKey.title}}</label>
									<input :type="searchKey.type" :id="searchKey.value" :name="searchKey.value" size="15" maxlength="20">
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
                	<a href="#" class="lHeader">分类浏览</a>
                </header>
                <div id="functions">
                    <ul type="none">
                        <li><a href="#" target="main" title="校园建设及风光">校园建设及风光</a></li>
                        <li><a href="#" target="main" title="毕业生合影">毕业生合影</a></li>
                        <li><a href="#" target="main" title="教工活动">教工活动</a></li>
                        <li><a href="#" target="main" title="运动会">运动会</a></li>
                        <li><a href="/uploadPictureJsp" target="main" title="领导视察">uploadPicture</a></li>
                    </ul>
                </div>
            </div>
            <div id="rightSection">
                <iframe src="/classifyScanJsp" name="main" allowtransparency="true" scrolling="no" frameborder="0" marginwidth="0" marginheight="0">
                </iframe>
            </div> 
        </div>
        <footer><address>Beijing University of Posts and Telecommunications 2016 Photo Album</address></footer>
    </div>
	<script src="/static/js/login.js" type="text/javascript" charset="gbk"></script>
	<script src="/static/js/advancedSearch.js" type="text/javascript"></script>
	<script src="/static/js/slideToggle.js" type="text/javascript" charset="gbk"></script>
	<script src="/static/js/getQueryStringArgs.js" type="text/javascript" charset="gbk"></script>
  </body>
</html>
