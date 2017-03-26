<%@ page language="java" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>test.jsp</title>

  </head>
  
  <body>
  <div align="center">
  <p>一个链接所写的JSP的页面,按首字母顺序排列</p><br/><br/>
  <a href="jsp/login.jsp">login.jsp</a><br/><br/>
  <a href="jsp/depManager.jsp">depAdmin.jsp</a><br/><br/>
  <a href="jsp/advancedSearch.jsp">advancedSearch.jsp</a><br/><br/>
  <a href="jsp/index.jsp">index.jsp</a><br/><br/>
  <a href="jsp/main.jsp">main.jsp</a><br/><br/>
  <a href="jsp/passerbyMain.jsp">passerbyMain.jsp</a><br/><br/>
  <a href="jsp/quickSearch.jsp">quickSearch.jsp</a><br/><br/>
  <a href="jsp/Function.jsp">Function.jsp</a><br/><br/>
  <a href="departmentJsp">departmentJsp</a><br/><br/>
  <a href="normalJsp">normalJsp</a><br/><br/>
  <a href="systemJsp">systemJsp</a><br/><br/>
  <p>hello world</p>
  <button onclick=window.close()>key</button>
  </div>
  </body>
</html>
