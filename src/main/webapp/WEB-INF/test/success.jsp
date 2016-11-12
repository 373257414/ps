<%@ page import="com.ycw.photosystem.bean.Picture" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: liuyang
  Date: 2016/11/9 0009
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
    success
    <div id="showPic">
        <%
            List<Picture> list = (List) request.getAttribute("pictures");
            List<String> paths = new ArrayList<>();
            for (Picture pic : list) {
                paths.add(pic.getPath());
        %>
        <img src="<%=pic.getPath()%>"/>
        <%
            }
        %>
    </div>
</head>
<body>

</body>
</html>
