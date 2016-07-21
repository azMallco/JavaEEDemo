<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/CustomerServlet?method=findAllWithCondition" method="post">
    <table>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name" value="${customer.name }"/></td>
            <td>性别</td>
            <td>
                <select name="gender">
                    <option value="">--请选择--</option>
                    <option value="男" ${customer.gender == "男" ? "selected='selected'" : ""}>男</option>
                    <option value="女" ${customer.gender == "女" ? "selected='selected'" : ""}>女</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>生日</td>
            <td colspan="3">
                <input type="text" name="startBirthday"/> --
                <input type="text" name="endBirthday"/>
            </td>
        </tr>
        <tr>
            <td>爱好</td>
            <td>
                <select name="preference">
                    <option value="">--请选择--</option>
                    <option value="高尔夫">高尔夫</option>
                    <option value="保龄球">保龄球</option>
                    <option value="斯诺克">斯诺克</option>
                    <option value="网球">网球</option>
                    <option value="蹦极">蹦极</option>
                </select>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="查询"/></td>
        </tr>
    </table>
</form>
<hr/>
<table border="1">
    <tr>
        <td>客户名称</td>
        <td>性别</td>
        <td>生日</td>
        <td>会员类型</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${allCustomer}" var="customer">
        <tr>
            <td>${customer.name}</td>
            <td>${customer.gender}</td>
            <td>${customer.birthday}</td>
            <td>${customer.type}</td>
            <td>
                <a href="${pageContext.request.contextPath}/CustomerServlet?method=preEdit&id=${customer.id}">修改</a>
                查询详情
                删除
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>