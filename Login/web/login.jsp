<%--
  Created by IntelliJ IDEA.
  User: lujiahao
  Date: 2016/6/22
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
    <form id="form_login" action="${pageContext.request.contextPath}/UserLoginServlet" method="post" >
        <table>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username" value="${requestScope.username}"/></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="userpwd"/></td>
            </tr>
            <th colspan="2" align="center">
                <input type="submit" value="登录"/>
            </th>
        </table>
    </form>
    <%--request作用域获取错误信息--%>
    <label>${requestScope.err_msg}</label>
</body>
</html>
