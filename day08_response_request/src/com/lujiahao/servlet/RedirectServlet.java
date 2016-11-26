package com.lujiahao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 重定向相关的servlet
 * Created by lujiahao on 2016/11/21.
 */
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 重定向 改变当前请求路径
        // 方式1
//        response.setStatus(302);
//        response.setHeader("location","redirect.html");
//        response.setHeader("location","/day08_response_request/redirect.html");
        // 方式2
//        response.sendRedirect("redirect.html");
        // 使用refresh头来实现和重定向相同的效果
        response.setHeader("refresh","0;url=redirect.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
