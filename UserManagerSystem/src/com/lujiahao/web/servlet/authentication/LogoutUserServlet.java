package com.lujiahao.web.servlet.authentication;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 注销
 * Created by lujiahao
 * Created at 2016/6/28 16:18
 */
public class LogoutUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser != null) {
            // 登录状态,进行注销
            request.getSession().removeAttribute("loginUser");
        }

        // 重定向到首页
        response.sendRedirect(request.getContextPath() +"/index.jsp");
    }
}
