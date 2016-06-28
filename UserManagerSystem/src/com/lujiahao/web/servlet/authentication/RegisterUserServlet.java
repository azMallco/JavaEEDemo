package com.lujiahao.web.servlet.authentication;

import com.lujiahao.domain.User;
import com.lujiahao.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lujiahao on 2016/6/28.
 */
public class RegisterUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 0.请求参数乱码解决
        request.setCharacterEncoding("UTF-8");
        try {
            // 1.获取请求参数
            String id = request.getParameter("id");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String gender = request.getParameter("gender");
            String age = request.getParameter("age");
            // 2.封装到User对象中
            User user = new User(id, username, password, gender, age);

            // 3.执行注册方法
            UserService userService = new UserService();
            userService.register(user);

            // 4.没有异常,说明注册成功
            // 使用请求转发告知一下注册结果
            request.setAttribute("msg", "注册成功");
            request.getRequestDispatcher("/pages/show_msg.jsp").forward(request, response);
        } catch (Exception e) {
            // 保存日志
            e.printStackTrace();
            // 使用请求转发告知一下注册结果
            request.setAttribute("msg", "注册失败,请重试");
            request.getRequestDispatcher("/pages/show_msg.jsp").forward(request, response);
        }
    }
}
