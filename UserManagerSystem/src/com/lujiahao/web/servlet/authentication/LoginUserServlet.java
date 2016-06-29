package com.lujiahao.web.servlet.authentication;

import com.lujiahao.domain.User;
import com.lujiahao.service.UserService;
import com.lujiahao.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户登录
 * Created by lujiahao
 * Created at 2016/6/28 15:53
 */
public class LoginUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 0.请求参数乱码处理
        request.setCharacterEncoding("UTF-8");
        // 1.获取请求参数并封装
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username,password);

        // 2.用户执行登录
        UserService userService = new UserServiceImpl();
        User loginUser = userService.login(user);

        if (loginUser != null) {
            // 登录成功  session存储用户登录信息  重定向到首页
            request.getSession().setAttribute("loginUser",loginUser);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        } else {
            // 登录失败 request中保存信息,请求转发到login.jsp页面显示信息
            request.setAttribute("msg","用户名和密码不匹配");
            //request.getRequestDispatcher(request.getContextPath()+"/pages/login.jsp").forward(request,response);
            request.getRequestDispatcher("/pages/login.jsp").forward(request,response);// 第一个/就表示了项目根目录
        }
    }
}
