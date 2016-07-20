<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lujiahao.cms.domain.Customer" %>
<%@ page import="java.util.Arrays" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/CustomerServlet?method=edit" method="post">
	<input type="hidden" name="id" value="${customer.id}"/>
	<table>
		<tr>
			<td>客户姓名</td>
			<td><input type="text" name="name" value="${customer.name}"/></td>
		</tr>
		<tr>
			<td>性别</td>
			<td>

				<input type="radio" name="gender" value="男" ${customer.gender == "男" ? "checked='checked'" : ""}/>男
				<input type="radio" name="gender" value="女" ${customer.gender == "女" ? "checked='checked'" : ""}/>女
			</td>
		</tr>
		<tr>
			<td>生日</td>
			<td><input type="text" name="birthday" value="${customer.birthday}"/></td>
		</tr>
		<tr>
			<td>手机</td>
			<td><input type="text" name="cellphone" value="${customer.cellphone}"/></td>
		</tr>
		<tr>
			<td>邮箱</td>
			<td><input type="text" name="email" value="${customer.email}"/></td>
		</tr>
		<tr>
			<td>爱好</td>
			<td>
                <%
                    List<String> list = new ArrayList<String>();
                    list.add("高尔夫");
                    list.add("保龄球");
                    list.add("斯诺克");
                    list.add("网球");
                    list.add("蹦极");
                    for (String str : list) {
                        // 从作用域中获取数据
                        Customer customer = (Customer) request.getAttribute("customer");
                        // 拆分字符串
                        String preference = customer.getPreference();
                        List checkList = new ArrayList();
                        if (preference != null) {
                            // 将拆分好的数组转成list
                            checkList = Arrays.asList(preference.split(","));
                        }
                        // 判断list中是否包含
                        String checkValue = "";
                        if (checkList.contains(str)){
                            checkValue = "checked='checked'";
                        }
                        out.print("<input type='checkbox' "+checkValue+"name='preferenceArr' value='"+str+"' />"+str);
                    }
                %>
			</td>
		</tr>
		<tr>
			<td>类型</td>
			<td>
				<select name="type">
					<option value="白金会员" ${customer.type == "白金会员" ? "selected='selected'" : ""}>白金会员</option>
					<option value="钻石会员" ${customer.type == "钻石会员" ? "selected='selected'" : ""}>钻石会员</option>
					<option value="重要客户" ${customer.type == "重要客户" ? "selected='selected'" : ""}>重要客户</option>
					<option value="普通客户"  ${customer.type == "普通客户" ? "selected='selected'" : ""}>普通客户</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>描述</td>
			<td>
				<textarea rows="5" cols="80" name="description">${customer.description}</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="提交编辑内容" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>