<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.UUID"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/CustomerServlet?method=add" method="post">
	<table>
		<tr>
			<td>客户姓名</td>
			<td><input type="text" name="name" /></td>
		</tr>
		<tr>
			<td>性别</td>
			<td>
				<input type="radio" name="gender" value="男"/>男
				<input type="radio" name="gender" value="女"/>女
			</td>
		</tr>
		<tr>
			<td>生日</td>
			<td><input type="text" name="birthday" /></td>
		</tr>
		<tr>
			<td>手机</td>
			<td><input type="text" name="cellphone"/></td>
		</tr>
		<tr>
			<td>邮箱</td>
			<td><input type="text" name="email"/></td>
		</tr>
		<tr>
			<td>爱好</td>
			<td>
				<input type="checkbox" name="preferenceArr" value="高尔夫" />高尔夫
				<input type="checkbox" name="preferenceArr" value="保龄球" />保龄球
				<input type="checkbox" name="preferenceArr" value="斯诺克" />斯诺克
				<input type="checkbox" name="preferenceArr" value="网球" />网球
				<input type="checkbox" name="preferenceArr" value="蹦极" />蹦极
			</td>
		</tr>
		<tr>
			<td>类型</td>
			<td>
				<select name="type">
					<option value="白金会员">白金会员</option>
					<option value="钻石会员">钻石会员</option>
					<option value="重要客户">重要客户</option>
					<option value="普通客户">普通客户</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>描述</td>
			<td>
				<textarea rows="5" cols="80" name="description"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="添加客户" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>