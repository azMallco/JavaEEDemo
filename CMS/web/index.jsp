<%--
  Created by IntelliJ IDEA.
  User: lujiahao
  Date: 2016/7/19
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <a href="${pageContext.request.contextPath}/pages/add.jsp">添加客户</a><br/>
    <a href="${pageContext.request.contextPath}/CustomerServlet?method=findAll">查询所有</a><br/>
  </body>
</html>
