<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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
					<a href="${pageContext.request.contextPath}/CustomerServlet?method=preEdit&id=${customer.id}" >修改</a>
					查询详情
					删除
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>