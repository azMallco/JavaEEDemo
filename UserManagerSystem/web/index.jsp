<%--
  Created by IntelliJ IDEA.
  User: lujiahao
  Date: 2016/6/24
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <%--两种方式进行重定向
        1.使用jsp脚本方式
        2.使用jstl标签
    --%>
    <%
      //response.sendRedirect(request.getContextPath() + "/FindAllUserServlet");
    %>
    <c:redirect url="/FindAllUserServlet"></c:redirect>
  </body>
</html>
