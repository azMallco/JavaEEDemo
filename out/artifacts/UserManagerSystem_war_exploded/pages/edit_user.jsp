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
    <title>Title</title>
    <script type="text/javascript">
        function setGender() {
            var genders = document.getElementsByName("gender");
            for (var i = 0; i < genders.length; i++) {
                if (genders[i].value == "${userById.gender}") {
                    genders[i].checked = "checked";
                }
            }
        }
    </script>
</head>
<body onload="setGender();">
<%@include file="header.jsp" %>
<form action="" method="post">
    <table border="1">
        <tr>
            <td>员工号</td>
            <td>${userById.id}</td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="username" value="${userById.username}"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password" value="${userById.password}"/></td>
        </tr>
        <tr>
            <td>性别</td>
            <td >
                <input type="radio" name="gender" value='男' />男
                <input type="radio" name="gender" value='女' />女
            </td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" name="age" value="${userById.age}"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交修改"/> </td>
        </tr>
    </table>
</form>
</body>
</html>
