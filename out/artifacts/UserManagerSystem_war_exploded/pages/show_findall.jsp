<%--
  Created by IntelliJ IDEA.
  User: lujiahao
  Date: 2016/6/27
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>所有用户信息</title>
</head>
<body>
    <%@include file="header.jsp"%>
    <table border="1">
        <tr>
            <td>编号</td>
            <td>员工号</td>
            <td>用户名</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${requestScope.allUser}" var="user" varStatus="vs">
            <tr>
                <td>${vs.count}</td>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/FindUserByIdServlet?id=${user.id}"> 查询详情</a>
                    <a href="${pageContext.request.contextPath}/PreEditUserServlet?id=${user.id}"> 修改</a>
                    删除</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
