<%--
  Created by IntelliJ IDEA.
  User: lujiahao
  Date: 2016/12/5
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/UserLoginServlet" method="POST">
        <table>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username" /></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="userpwd" /></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" name="登录" /></td>
            </tr>
        </table>
    </form>
    <%--request作用域获得错误提示信息--%>
    ${requestScope.msg}
</body>
</html>
