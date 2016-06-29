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
    <%@include file="header.jsp"%>
    <form action="${pageContext.request.contextPath}/RegisterUserServlet" method="post">
        <table border="1">
            <tr>
                <td>员工号</td>
                <td><input type="text" name="id" ${userFormBean.id}/></td>
            </tr>
            <tr>
                <td>姓名</td>
                <td><input type="text" name="username" value="${userFormBean.username}"/> ${userFormBean.errorMsg.usernameMsg}</td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password" value="${userFormBean.password}"/>${userFormBean.errorMsg.passwordMsg}</td>
            </tr>
            <tr>
                <td>确认密码</td>
                <td><input type="password" name="repassword" value="${userFormBean.repassword}"/>${userFormBean.errorMsg.repasswordMsg}</td>
            </tr>
            <tr>
                <td>性别</td>
                <td>
                    <input type="radio" name="gender" checked="checked" value="男"/>男
                    <input type="radio" name="gender" value="女"/>女
                </td>
            </tr>
            <tr>
                <td>年龄</td>
                <td><input type="text" name="age" value="${userFormBean.age}"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" name="id" value="注册" /></td>
            </tr>
        </table>
    </form>
</body>
</html>
