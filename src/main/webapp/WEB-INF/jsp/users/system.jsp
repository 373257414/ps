<%@ page language="java" pageEncoding="utf-8"%>

<!DOCTYPE>
<html>
<head>
    <title>北京邮电大学|图片管理系统|系统管理员</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-default/index.css">
    <link rel="stylesheet" href="static/css/reset.css" media="screen">
    <link rel="stylesheet" href="static/css/mainFrame.css" media="screen">
    <script src="static/js/jquery-2.2.4.js" type="text/javascript"></script>
    <script src="https://unpkg.com/vue/dist/vue.js"></script>
    <script src="https://unpkg.com/element-ui/lib/index.js"></script>
</head>
<body>
<div id="container">
    <header>
        <img src="static/img/topbackground.jpg" align="middle" alt="北京邮电大学照片档案管理系统" id="topBackground">
        <nav id="navBar">
            <ul>
                <li v-for="navBar in navBars"><a :href="navBar.href" :title="navBar.title">{{navBar.title}}</a></li>
            </ul>
        </nav>
    </header>
    <div id="mainSection">
        <div id="leftSection">
            <header class="leftHeader">
                <a href="javascript:;" class="lHeader" @click="headerToggle">用户信息</a>
            </header>
            <div id="userSection" class="firstSection">
                <div id="information">
                    <p>欢迎：<a href="userInformationJsp" target="main">${sessionScope.currentUser.nickname}</a></p>
                    <p>权限：系统管理员</p>
                    <p><el-button-group>
                            <a href="userInformationJsp" target="main"><el-button type="primary" >查看</el-button></a>
                            <a href="loginJsp"><el-button type="danger">注销</el-button></a>
                    </el-button-group></p>
                </div>
            </div>
            <header class="leftHeader">
                <a href="javascript:;" class="lHeader" @click="headerToggle">图片搜索</a>
            </header>
            <div id="searchSection">
                <form id="Q_searchForm">
                    <div id="Q_inputSec">
                        <select name="searchKeys" size="1" id="searchKeys">
                            <option v-for="searchKey in searchKeys" :value="searchKey.value">{{searchKey.title}}</option>
                            <option v-for="selectInput in selectInputs" :value="selectInput.name">{{selectInput.title}}</option>
                        </select>
                        <input type="text" name="keywords" required="required"/>
                    </div>
                    <div id="Q_searchBtn">
                        <el-col :offset="5"><el-button-group>
                            <el-button type="primary" native-type="submit" size="small" icon="search">搜索</el-button>
                            <el-button type="danger" native-type="reset" size="small" icon="delete">清空</el-button>
                        </el-button-group></el-col>
                    </div>
                </form>
                <a href="javascript:;" title="高级搜索" id="A_Search_link" @click="advancedSearchToggle"><img src="static/img/ZHYgodown16.png" class="icon_inline icon_change_search"/>高级搜索<img src="static/img/ZHYgodown16.png" class="icon_inline icon_change_search"/></a>
                <div id="A_SearchSection">
                    <form id="A_searchForm">
                        <div id="A_inputSec">
                            <p v-for="searchKey in searchKeys">
                                <label :for="searchKey.value">{{searchKey.title}}</label>
                                <input :type="searchKey.type" :id="searchKey.value" :name="searchKey.value" size="15" maxlength="20">
                            </p>
                            <p v-for="select in selectInputs">
                                <label :for="select.name">{{select.title}}</label>
                                <select :name="select.name" :id="select.name">
                                    <option v-for="option in select.options" :value="option.value">{{option.label}}</option>
                                </select>
                            </p>
                        </div>
                        <div id="A_check">
                            <input type="radio" value="accurateSearch" name="check" title="照片符合所有选择条件" checked="check"/>精确搜索
                            <input type="radio" value="blurySearch" name="check" title="照片符合任意一个选择条件即可"/>模糊搜索
                        </div>
                        <div id="A_searchBtn">
                            <el-col :offset="5"><el-button-group>
                                <el-button type="primary" native-type="submit" size="small" icon="search">搜索</el-button>
                                <el-button type="danger" native-type="reset" size="small" icon="delete">清空</el-button>
                            </el-button-group></el-col>
                        </div>
                    </form>
                </div>
            </div>
            <header class="leftHeader">
                <a href="javascript:;" class="lHeader" @click="headerToggle">用户功能</a>
            </header>
            <div id="functions">
                <ul type="none">
                    <li v-for="systemFunction in systemFunctions"><a :href="systemFunction.href" target="main" :title="systemFunction.title">{{systemFunction.title}}</a></li>
                </ul>
            </div>
        </div>
        <div id="rightSection">
            <iframe src="classifyScanJsp" name="main" allowtransparency="true" scrolling="no" frameborder="0" marginwidth="0" marginheight="0">
            </iframe>
        </div>
    </div>
    <footer><address>Beijing University of Posts and Telecommunications 2016 Photo Album</address></footer>
</div>
<script src="static/js/mainFrame.js" type="text/javascript" charset="gbk"></script>
</body>
</html>
