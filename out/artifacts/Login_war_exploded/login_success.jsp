<%--
  Created by IntelliJ IDEA.
  User: lujiahao
  Date: 2016/6/22
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
    <c:if test="${not empty sessionScope.loginUser}">
        欢迎您:${sessionScope.loginUser.name}
    </c:if>
    <c:if test="${empty sessionScope.loginUser}">
        您还未登录,请重新<a href="login.jsp">登录</a>
    </c:if>

</body>
</html>
