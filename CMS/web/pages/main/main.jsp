<%--
  Created by IntelliJ IDEA.
  User: lujiahao
  Date: 2016/7/21
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我是主页</title>
</head>
<body>
我是主页
${loginCustomer.name}
<a href="${pageContext.request.contextPath}/AuthenticationServlet?method=logout">注销</a><br/>
<a href="${pageContext.request.contextPath}/pages/register/register.jsp">添加客户</a><br/>
<a href="${pageContext.request.contextPath}/CustomerServlet?method=findAll">查询所有</a><br/>
<a href="${pageContext.request.contextPath}/CustomerServlet?method=findAllWithCondition">查询所有-条件查询</a><br/>
</body>
</html>
