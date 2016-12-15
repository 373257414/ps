<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@include file="/WEB-INF/settings/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>北京邮电大学 | 图片档案馆</title>
    <link rel="stylesheet" type="text/css" href="/static/css/main.css">
    <script type="text/javascript" src="test.js"></script>
</head>

<body scroll="no">
<div align="center">
    <table border="0">
        <tr>
            <td colspan="2" align="center"><img src="${ctx}/static/img/top.jpg"
                                                style="opacity:0.8">
                <p align="left">
                    <a onclick="test()" href="#">首页</a> <a onclick="test()" href="#">人气排行</a>
                </p>
            </td>
        </tr>

        <!--主体部分-->
        <tr>
            <td valign="top" height="600">
                <table class="tableBack">
                    <tr>
                        <td colspan="2">
                            <p align="center" class="op">用户登录</p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <form action="/login" method="post">
                                <p>
                                    <img src="${ctx}/static/img/user.png" style="width:40px">用户: <input
                                        type="text" name="userName" id="userName" style="width:100px"/>
                                </p>
                                <p>
                                    <img src="${ctx}/static/img/psw.png" style="width:40px">密码: <input
                                        type="password" name="password" id="password"
                                        style="width:100px"/>
                                </p>
                                <div align="right">
                                    <button type="submit">登陆</button>
                                    <button type="reset">重置</button>
                                </div>
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><p align="center" class="op">图片搜索</p></td>
                    </tr>
                    <tr>
                        <td align="center" colspan="2">快速搜索</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div align="center">
                                <select class="op">
                                    <option>--请选择--</option>
                                    <option>档案号</option>
                                    <option>关键人物</option>
                                    <option>图片说明</option>
                                    <option>归档部门</option>
                                </select>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td><input type="textarea" id="search4Pic"
                                   style="width:100px">
                        </td>
                        <td>
                            <button style="width:100px">查找</button>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <p align="center">
                                <a onclick="test()" href="jsp/advancedSearch.jsp" target="main">高级搜索</a>
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><p align="center" class="op">分类浏览</p></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <p align="center">
                                <a onclick="test()" href="#">校园建设及风光</a>
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <p align="center">
                                <a onclick="test()" href="#">毕业生合影</a>
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <p align="center">
                                <a onclick="test()" href="#">教工活动</a>
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <p align="center">
                                <a onclick="test()" href="#">学生活动</a>
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <p align="center">
                                <a onclick="test()" href="#">科研活动</a>
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <p align="center">
                                <a onclick="test()" href="#">行政管理</a>
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <p align="center">
                                <a onclick="test()" href="#">教学活动</a>
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <p align="center">
                                <a onclick="test()" href="#">各种表彰</a>
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <p align="center">
                                <a onclick="test()" href="#">各种评估认证</a>
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <p align="center">
                                <a onclick="test()" href="#">各种典礼仪式</a>
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <p align="center">
                                <a onclick="test()" href="#">外事活动</a>
                            </p>
                        </td>
                    </tr>
                    <!-- <tr>
        <td colspan="2">
            <p align="center">
                <a onclick="test()" href="#">学生活动</a>
            </p>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <p align="center">
                <a onclick="test()" href="#">学生活动</a>
            </p>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <p align="center">
                <a onclick="test()" href="#">学生活动</a>
            </p>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <p align="center">
                <a onclick="test()" href="#">学生活动</a>
            </p>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <p align="center">
                <a onclick="test()" href="#">学生活动</a>
            </p>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <p align="center">
                <a onclick="test()" href="#">学生活动</a>
            </p>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <p align="center">
                <a onclick="test()" href="#">学生活动</a>
            </p>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <p align="center">
                <a onclick="test()" href="#">学生活动</a>
            </p>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <p align="center">
                <a onclick="test()" href="#">学生活动</a>
            </p>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <p align="center">
                <a onclick="test()" href="#">学生活动</a>
            </p>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <p align="center">
                <a onclick="test()" href="#">学生活动</a>
            </p>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <p align="center">
                <a onclick="test()" href="#">学生活动</a>
            </p>
        </td>
    </tr> -->
                </table>
            </td>

            <!--展现部分-->
            <td valign="top">
                <div align="center">
                    <iframe src="/mainPictureJsp" name="main" scrolling="no"
                            frameborder="0" border="0" width="800" height="600"
                            style="position:relative"></iframe>
                </div>
            </td>
        </tr>

        <!-- 底部说明 -->
        <tr>
            <td colspan="2">
                <hr>
                <div align="center" class="bottom">
                    <p>Beijing University of Posts and Telecommunications 2016
                        Photo Album</p>
                </div> <!-- <hr> -->
            </td>
        </tr>
    </table>
</div>
</body>
</html>
