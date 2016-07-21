<%--
  Created by IntelliJ IDEA.
  User: lujiahao
  Date: 2016/7/21
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" type="text/css" href="public.css">
</head>
<body>
<div class="login-container">
    <p>
        <img src="/images/logo-login.png">
    </p>

    <c:if test="${not empty msg}">
        <p align="center"><font color="red">${msg}<br/></font></p>
    </c:if>
    <form action="${pageContext.request.contextPath}/AuthenticationServlet?method=login" method="post">
        <ul>
            <li>
                <input name="name" type="text" class="input-login" placeholder="请输入用户名" value="${customer.name}"/>
            </li>
            <li>
                <input name="pwd" type="text" class="input-login" placeholder="请输入密码"/>
            </li>
        </ul>
        <div class="rem-container clearfix">
            <div class="ga-checkbox fl">
                <input type="checkbox" class="ng-pristine ng-valid" checked=""><b></b>记住我
            </div>
            <a href="" class="fr">忘记密码？</a>
        </div>
        <button class="btn-login clearfix">登录</button><br/>
    </form>
    <a href="${pageContext.request.contextPath}/pages/register/register.jsp" style="text-decoration: none" class="btn-register clearfix">
        注册
    </a>
</div>
</body>
</html>
