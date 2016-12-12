<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<form action="/addUser" method="post">
    请输入注册用户名：<input type="text" name="userName"/><br/>
    请输入密码：<input type="password" name="password"/><br/>
    请选择部门：
    <select name="departmentId">
        <c:forEach items="${departments}" var="department">
            <option value=${department.key}>${department.value}</option>
        </c:forEach>
    </select>
    请选择权限：<input type="text" name="permissionId"/><br/>
</form>
</body>
</html>