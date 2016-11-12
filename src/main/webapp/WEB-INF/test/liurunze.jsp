<%@ page language="java" pageEncoding="utf-8" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'liurunze.jsp' starting page</title>
</head>

<body>
<div id="loginDiv">
    <p>------------------------------------------------------------------</p>
    <h1>用户登录</h1>
    <form action="/user/login" method="post">
        <input name="userName" type="text"/>
        <input name="password" type="password"/>
        <input value="submit_value" type="submit"/>
        <input value="reset_value" type="reset"/>
    </form>
</div>
<%--<div>
    <p>------------------------------------------------------------------</p>
    <p>JSP直接显示数据库的存值</p>
    <%
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        UserService userService = (UserService) applicationContext
                .getBean("userService");
			/* for (int i = 0; i < list.size(); i++) {
				User user = (User) list.get(i);
				out.println(user.getUserName());
			} */
        // 			Iterator iterator = list.iterator();
        // 			while (iterator.hasNext()) {
        // 			User user = (User)iterator.next();
        // 			out.println(user.getUserName());
        //			}
    %>
</div>--%>
<%--<div>
    <p>------------------------------------------------------------------</p>
    <p>显示httpsession中的全部值</p>
    <%
        Enumeration<String> enumeration = session.getAttributeNames();
        while (enumeration.hasMoreElements()) {
            String string = (String) enumeration.nextElement();
            out.print("[" + string + "," + session.getAttribute(string)
                    + "]");
    %>
    <br>
    <%
        }
    %>

</div>--%>
<%--<div id="addUserDiv">
    <p>------------------------------------------------------------------</p>
    <h1>添加用户</h1>
    <form action="addUserAction" method="post"
          enctype="application/x-www-form-urlencoded">
        用户名：<input type="text" name="userName"> 密码：<input type="text"
                                                          name="password"> 部门：<input type="text" name="departmentId">
        权限：<input type="text" name="permissionId"> <input
            type="submit" value="注册用户">
    </form>
</div>
<div id="deleteUserDiv">
    <p>------------------------------------------------------------------</p>
    <h1>删除用户</h1>
    <form action="deleteUserAction" method="post"
          enctype="application/x-www-form-urlencoded">
        用户名：<input type="text" name="userName"> <input type="submit"
                                                       value="删除用户">
    </form>
</div>
<div id="updateUserDiv">
    <p>------------------------------------------------------------------</p>
    <h1>更新用户</h1>
    <form action="updateUserAction" method="post"
          enctype="application/x-www-form-urlencoded">
        用户名：<input type="text" name="userName"><br/> 密码：<input
            type="text" name="password"><br/> 部门：<input type="text"
                                                        name="departmentId"><br/> 权限：<input type="text"
                                                                                            name="permissionId"><br/>
        <input type="submit"
               value="更新用户"><br/>
    </form>
</div>--%>
<div uploadPicDiv>
    <p>------------------------------------------------------------------</p>
    <h1>图片上传</h1>
    <form action="/picture/upload" method="post" enctype="multipart/form-data">
        部门ID：<input type="text" name="departmentId"><br/>
        目录ID：<input type="text" name="categoryId"><br/>
        作者：<input type="text" name="author"><br/>
        图片：<input type="file" name="file"><br/>
        <input type="submit" value="上传">
    </form>
</div>

<div searchPicDiv>
    <p>------------------------------------------------------------------</p>
    <h1>图片搜索</h1>
    <form action="/picture/search" method="post">
        ID：<input type="text" name="id"><br/>
        名称：<input type="text" name="name"><br/>
        <input type="submit" value="搜索">
    </form>
</div>
</body>
</html>
