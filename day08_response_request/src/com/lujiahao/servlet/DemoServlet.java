package com.lujiahao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lujiahao on 2016/11/20.
 */
public class DemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.统一字段标记符
        String uri = request.getRequestURI();
        System.out.println(uri);

        // 2.统一资源定位符
        StringBuffer url = request.getRequestURL();
        System.out.println(url);

        // 3.协议和版本
        String protocol = request.getProtocol();
        System.out.println(protocol);

        // 4.协议
        String scheme = request.getScheme();
        System.out.println(scheme);

        // 5.主机(域名)
        String serverName = request.getServerName();
        System.out.println(serverName);

        // 6.端口
        int port = request.getServerPort();
        System.out.println(port);

        // 7.发布到tomcat下的项目名称
        String contextPath = request.getContextPath();
        System.out.println(contextPath);

        // 8.servlet路径
        String servletPath = request.getServletPath();
        System.out.println(servletPath);

        // 9.所有请求参数
        String queryString = request.getQueryString();
        System.out.println(queryString);

        // 10.远程主机ip地址
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
