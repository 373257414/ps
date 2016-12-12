<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台测试首页</title>
    <%

    %>
</head>
<body>
<div>
    <h1>部门</h1>
    <form action="/mainDepartmentJsp" method="get"><input type="submit" value="部门界面"></form>
    <form action="/addDepartmentJsp" method="get"><input type="submit" value="添加部门"></form>
</div>
<div>
    <h1>用户</h1>
    <form action="/userIndex" method="get"><input type="submit" value="用户界面"/></form>
    <form action="/addUserJsp" method="get"><input type="submit" value="添加用户"/></form>
</div>


</body>
</html>
