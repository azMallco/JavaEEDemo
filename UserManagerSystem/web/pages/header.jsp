<%--
  Created by IntelliJ IDEA.
  User: lujiahao
  Date: 2016/6/28
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a href="${pageContext.request.contextPath}/FindAllUserServlet">首页</a>

<%--用户没有登录,显示登录和注册--%>
<c:if test="${empty loginUser}">
    <a href="${pageContext.request.contextPath}/pages/register.jsp">注册</a>
    <a href="${pageContext.request.contextPath}/pages/login.jsp">登录</a>
</c:if>

<%--用户登录,显示欢迎和注销--%>
<c:if test="${not empty loginUser}">
    欢迎,${loginUser.username}&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}/LogoutUserServlet">注销</a>
</c:if>


<hr/>