<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>部门界面</title>
</head>
<body>
<table>
    <tr>
        <th>部门id</th>
        <th>名称</th>
        <th>负责人</th>
        <th>地址</th>
        <th>电子邮件</th>
    </tr>
    <c:forEach items="${departments}" var="department">
        <tr>
            <td>${department.id}</td>
            <td>${department.name}</td>
            <td>${department.charger}</td>
            <td>${department.address}</td>
            <td>${department.email}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
