package com.lujiahao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lujiahao on 2016/11/27.
 */
public class RememberFormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0 响应中文乱码
        response.setContentType("text/html;charset=UTF-8");

        // 先从浏览器中取得cookie,如果有就显示上,没有就不显示
        String username = "";
        String checkedStr = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username_cookie".equals(cookie.getName())) {
                    username = cookie.getValue();
                    checkedStr = " checked='checked' ";
                }
            }
        }

        // 1.流发送html源码
        PrintWriter out = response.getWriter();
        out.print("<form action='/day09_cookie_session/LoginServlet' method='post'>");
        out.print("用户名:<input type='text' name='username' value='" + username + "'/><br/>");
        out.print("<input type='checkbox' name='rememberme' " + checkedStr + " />记住用户名<br/>");
        out.print("<input type='submit' value='登录'/>");
        out.print("</form>");
    }
}
