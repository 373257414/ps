<%@ page language="java" pageEncoding="utf-8" %>

<!DOCTYPE HTML>
<html>
<head>

    <title>北京邮电大学|图片档案馆|个人信息</title>

    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <link rel="stylesheet" href="/static/css/userInformation.css" media="screen">
    <link rel="stylesheet" href="/static/css/reset.css" media="screen">
    <script src="/static/js/jquery-2.2.4.js" type="text/javascript"></script>
    <script src="/static/js/userInfoChange.js" type="text/javascript"></script>
</head>

<body>
<div id="container">
    <header>
        <h1>个人信息</h1>
    </header>
    <div id="mainSection">
        <div>
            <table width="350" height="200" align="center" border="1">
                <tbody align="center">
                <tr>
                    <td>用户昵称</td>
                    <td>${sessionScope.currentUser.nickname} &nbsp&nbsp&nbsp&nbsp<a id="pwdChange" href="#">修改登录密码</a>
                    </td>
                </tr>
                <tr>
                    <td>电子邮箱</td>
                    <td>${sessionScope.currentUser.email} &nbsp&nbsp&nbsp&nbsp<a id="emailChange" href="#">修改电子邮箱</a>
                    </td>
                </tr>
                <tr>
                    <td>所属部门</td>
                    <td>${sessionScope.currentUser.userDepartment.name}</td>
                </tr>
                <tr>
                    <td>所属权限</td>
                    <td>${sessionScope.currentUser.userPermission}</td>
                </tr>
                </tbody>
            </table>
        </div>
        <div id="pwdChangeSection">
            <form action="/updatePasswordAction" method="post">
                <div id="password" class="textInput">
                    <p>
                        <label for="oldPassword">请输入当前密码：</label>
                        <input type="password" id="oldPassword" name="oldPassword" size="25"/>
                    </p>
                    <p>
                        <label for="newPassword1">请输入新密码：</label>
                        <input type="password" id="newPassword1" name="newPassword1" size="25"/>
                    </p>
                    <p>
                        <label for="newPassword2">请再次输入新密码：</label>
                        <input type="password" id="newPassword2" name="newPassword2" size="25"/>
                    </p>
                </div>
                <div id="btnForPwd" class="buttons">
                    <input type="submit" value="确认更改" name="sendBtn"/>
                    <input type="reset" value="全部清空" name="resetBtn" class="resetBtn"/>
                </div>
            </form>
        </div>
        <div id="emailChangeSection">
            <form action="/updateEmailAction" method="post">
                <div id="email" class="textInput">
                    <p>
                        <label for="userName">请输入当前用户名：</label>
                        <input type="text" id="userName" size="25" placeholder="your username"/>
                    </p>
                    <p>
                        <label for="pwdForEmail">请输入当前密码：</label>
                        <input type="password" id="pwdForEmail" name="password" size="25" placeholder="your password"/>
                    </p>
                    <p>
                        <label for="newEmail">请输入新邮箱地址：</label>
                        <input type="text" id="newEmail" size="25" name="newEmail" placeholder="new email address"/>
                    </p>
                </div>
                <div id="btnForEmail" class="buttons">
                    <input type="submit" value="确认更改" name="sendBtn"/>
                    <input type="reset" value="全部清空" name="resetBtn" class="resetBtn"/>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
