package com.lujiahao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lujiahao on 2016/11/27.
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.getOutputStream().print("aaaaa");
        // 0乱码处理
        // 1.获得用户名
        String username = request.getParameter("username");
        // 2.获得是否勾选  如果没有勾选返回null,如果勾选返回默认值on  当然也可以通过value设置具体的值
        String rememberme = request.getParameter("rememberme");
        if (rememberme != null) {
            // 3.勾选  采用cookie,将用户名记录到浏览器
            Cookie cookie = new Cookie("username_cookie",username);
            cookie.setPath("/");
            cookie.setMaxAge(60*60*24);
            // 4.将cookie发送到浏览器
            response.addCookie(cookie);
        } else {
            // 没有勾选,需要通知浏览器删除这个cookie
            Cookie cookie = new Cookie("username_cookie","");
            cookie.setPath("/");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }
}
