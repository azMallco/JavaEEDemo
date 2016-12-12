<%--
  Created by IntelliJ IDEA.
  User: lujiahao
  Date: 2016/12/12
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%-- el函数，el表达式中对字符串处理
        格式： ${fn:函数(....)}
        嵌套格式： ${fn:xx(fn:yy(....))}
    --%>
    1: ${fn:contains("abc","a")} <br/>	<%--true --%>
    2: ${fn:contains("abc","A")} <br/>  <%--false , 区分大小的 --%>

    3: ${fn:containsIgnoreCase("abc", "A")} <br/> <%--true --%>
    4: ${fn:endsWith("mm.jpg", ".jpg")} <br/> <%--true --%>

    5: ${fn:escapeXml("<a href=''>点我</a>")} <br/> <%--是否进行转义 ，例如在html源码中将 < 转义成 &lt; --%>
    5.1: ${"<a href=''>点我</a>"} <br/>  <%--没有转码的直接输出,会被浏览器解析形成连接的形式 --%>

    6: ${fn:indexOf("itheima", "h")} <br/>  <%--h第一次出现的索引 : 2 --%>

    <%
        String[] str = {"www","itheima","com"};
        pageContext.setAttribute("str", str);
    %>
    7: ${fn:join(str, ".")} <br/> <%--将指定的数组，按照分隔符进行连接  最后输出结果:www.itheima.com--%>
    str: ${str} <br/>

    8: ${fn:length("liangtong")} <br/>  <%--字符串长度 : 9 --%>

    9:  ${fn:replace("itcast", "cast", "heima")} <br/> <%--替换字符串 itheima --%>

    10:  ${fn:split("www.itheima.com", ".")} <br/> <%--切割字符串--%>
    10.1 ${fn:join(fn:split('www.itheima.com','.'),'-') }  <br/>

    11:  ${fn:startsWith("UserServlet", "User")} <br/> <%--判断是否以规定字符串开头 true --%>

    12:  ${fn:substring("itheima", 2, 3)} <br/>  <!-- [2,3) 第三个参数，截取的结束索引 -->
    12.1:  ${fn:substring("itheima", 2, -1)} <br/>  <!-- 第二个参数：截取的开始索引，第三个参数，如果是-1表示最后 -->


    13:  ${fn:substringAfter("itheima", "m")} <br/>  <!-- 截取m之后的-->
    14:  ${fn:substringBefore("itheima", "m")} <br/>  <!-- 截取m之前的 -->

    15:  ${fn:toLowerCase("AbcDeFg")} <br/> <!-- 转化成小写-->
    16:  ${fn:toUpperCase("AbcDeFg")} <br/> <!-- 转化成大写-->

    17:  ${fn:trim("   A  B   ")}# <br/>  <!-- 去掉两端的空格,中间的空格还在-->


    ${myfn:sub("这是一个屌丝必备的神器，屌炸天",10,"...")}
</body>
</html>
