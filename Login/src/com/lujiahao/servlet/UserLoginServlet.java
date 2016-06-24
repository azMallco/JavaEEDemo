package com.lujiahao.servlet;

import com.lujiahao.vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lujiahao on 2016/6/22.
 */
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 请求乱码
        request.setCharacterEncoding("UTF-8");

        // 获取用户名和密码  --  将获得的数据封装到javabean中
        String username = request.getParameter("username");
        String userpwd = request.getParameter("userpwd");

        // 手动封装数据
        User user = new User(username,userpwd);

        // 使用javabean数据查询用户
        //User loginUser = UserDB.find(user);

        // 模拟数据  不是lujiahao返回null,就相当于没有查到数据
        User loginUser = null;
        if ("lujiahao".equals(username) && "123".equals(userpwd)){
            loginUser = new User("u001",user.getName(),user.getPwd(),19,"男");
        }

        // 登录处理
        if (loginUser != null) {
            // 登录成功---session保存登录用户信息,重定向成功页面
            // session保存登录状态
            request.getSession().setAttribute("loginUser",loginUser);
            // 重定向到成功页面
            String url = request.getContextPath() + "/login_success.jsp";
            response.sendRedirect(url);
        } else {
            // 登录失败---request设置错误,使用请求转发,在登陆页面显示提示信息
            // request作用域保存错误信息(当前请求,之后的请求是否出错未知)
            request.setAttribute("err_msg","用户名和密码不匹配");
            request.setAttribute("username",username);
            // 使用请求转发(一次请求涉及到多个页面:UserLoginServlet --> login.jsp
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
