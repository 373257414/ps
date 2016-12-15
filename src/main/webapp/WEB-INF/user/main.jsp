<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>用户id</th>
        <th>用户名</th>
        <th>昵称</th>
        <th>创建时间</th>
        <th>部门</th>
        <th>权限</th>

    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.nickname}</td>
            <td>${user.createTime}</td>
            <td>${user.department}</td>
            <td>${user.permission}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
