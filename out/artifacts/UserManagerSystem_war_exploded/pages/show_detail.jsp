<%--
  Created by IntelliJ IDEA.
  User: lujiahao
  Date: 2016/6/28
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@include file="header.jsp"%>

    <table border="1">
        <tr>
            <td>员工号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>年龄</td>
        </tr>
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.gender}</td>
            <td>${user.age}</td>
        </tr>
    </table>
</body>
</html>
