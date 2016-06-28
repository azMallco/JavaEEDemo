<%--
  Created by IntelliJ IDEA.
  User: lujiahao
  Date: 2016/6/28
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<%@include file="header.jsp" %>

<c:if test="${not empty msg}">
    <font color="red">${msg}<br/></font>
</c:if>

<form action="${pageContext.request.contextPath}/LoginUserServlet" method="post">
    <table border="1">
        <tr>
            <td>姓名</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" name="id" value="登录"/></td>
        </tr>
    </table>
</form>
</body>
</html>
