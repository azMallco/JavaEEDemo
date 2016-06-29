package com.lujiahao.web.servlet.edit;

import com.lujiahao.domain.User;
import com.lujiahao.service.UserService;
import com.lujiahao.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 预修改
 * Created by lujiahao
 * Created at 2016/6/28 16:51
 */
public class PreEditUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 0.请求参数乱码
        request.setCharacterEncoding("UTF-8");
        // 1.获得请求参数id的值
        String id = request.getParameter("id");
        // 2.查询用户信息
        UserService userService = new UserServiceImpl();
        User userById = userService.findUserById(id);
        // 3.将数据保存到request作用域中  请求转发到edit_user.jsp
        request.setAttribute("userById",userById);
        request.getRequestDispatcher("/pages/edit_user.jsp").forward(request,response);
    }
}
