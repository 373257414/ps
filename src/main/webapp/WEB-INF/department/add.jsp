<%--
  Created by IntelliJ IDEA.
  User: liuyang
  Date: 2016/12/11 0011
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加部门</title>
</head>
<body>
<form action="/addDepartment" method="post">
    添加部门请完整输入一下信息<br/>
    部门名称：<input type="text" name="name"/><br/>
    部门负责人：<input type="text" name="charger"/><br/>
    部门地址：<input type="text" name="address"/><br/>
    部门电子邮箱：<input type="text" name="email"/><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
