<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: lujiahao
  Date: 2016/12/12
  Time: 7:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    1.自定义数据必须放在作用域中<br/>
    <%
        String name = "路家豪";
        pageContext.setAttribute("name",name);
    %>
    ${name}
    <hr/>
    2.el中的注释方式:在表达式前面添加"\"<br/>
    \${1+1}
    <hr/>
    3.数字和字符串的各种坑<br/>
    \${1+1} = ${1+1} <br/>
    \${a+1} = ${a+1} el会从作用域中获取a的值,如果没有返回值,返回null,如果是null计算时等效于0<br/>
    \${'1'+1} = ${'1'+1} el中单引号和双引号都表示字符串,这里相当于执行了Integer.parseInt('1');是没有问题的<br/>
    \${'a'+1} 这个会报异常信息java.lang.NumberFormatException,'a'是字符串,进行数字格式化会出异常<br/>
    <hr/>
    4.el中精度问题<br/>
    jsp中10/3 = <%=10/3%><br/>
    el中10/3 = ${10/3}
    <hr/>
    5.empty 表示空 三种情况:null,"",list.size()==0 <br/>
    \${empty book} = ${empty book}<br/>
    <%
        pageContext.setAttribute("person","");
    %>
    \${empty person} = ${empty person}<br/>
    <%
        pageContext.setAttribute("list",new ArrayList());
    %>
    \${empty list} = ${empty list}
    <hr/>
    6.三目运算符<br/>
    \${5>3 ? "true*" : "false*"} = ${5>3 ? "true*" : "false*"}
    <hr/>
    7.遍历list集合<br/>
    <%
        List listData = new ArrayList();
        listData.add("haha");
        listData.add("hehe");
        listData.add("huhu");
        pageContext.setAttribute("listData",listData);
    %>
    \${listData} = ${listData} list在el中输出的格式是:[,,,,]<br/>
    \${listData[2]} = ${listData[2]} 使用角标即可
    <hr/>
    8.遍历map<br/>
    <%
        Map<String,String> map = new HashMap<String,String>();
        map.put("k007","大内密探");
        map.put("k-008","大外明探");
        pageContext.setAttribute("map",map);
    %>
    \${map} = ${map} map在el中输出的格式是:{k=v,k=v}<br/>
    \${map.k007} = ${map.k007} 使用角标<br/>
    \${map['k-008']} = ${map['k-008']} 如果有特殊的字符,就使用[]<br/>
    注意:<br/>
        在代码里面必须得写上具体的泛型 不然会报错
</body>
</html>
