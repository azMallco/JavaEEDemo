package com.lujiahao.servlet;

import com.lujiahao.vo.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lujiahao on 2016/12/5.
 */
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 0.处理乱码
        request.setCharacterEncoding("UTF-8");
        // 获取用户名和密码
        String username = request.getParameter("username");
        String userpwd = request.getParameter("userpwd");

        // 手动封装数据
        User user = new User(username,userpwd);

        User userLogin = null;
        // 模拟查询数据库相关
        if ("lujiahao".equals(username) && "123".equals(userpwd)) {
            userLogin = new User("lujiahao","123");
        }

        // 登录处理
        if (userLogin != null) {
            // 登录成功   session保存用户信息 重定向到成功界面
            request.getSession().setAttribute("userLogin",userLogin);
            // 重定向
            String url = request.getContextPath() + "/login_success.jsp";
            response.sendRedirect(url);
        } else {
            // 登录失败   request设置错误,请求转发,在登录页面显示提示信息
            // request作用域保存错误信息
            request.setAttribute("msg","用户名和密码不匹配");
            request.setAttribute("username",username);
            // 使用请求转发(一次请求涉及到多个页面)
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
