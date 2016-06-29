package com.lujiahao.web.servlet.delete;

import com.lujiahao.domain.User;
import com.lujiahao.service.UserService;
import com.lujiahao.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除用户
 * Created by lujiahao
 * Created at 2016/6/29 14:55
 */
public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        UserService userService = new UserServiceImpl();
        User deleteUser = userService.deleteUser(id);
        if (deleteUser != null) {
            // 删除成功 提示
            request.setAttribute("msg","删除成功");
        } else {
            // 删除失败 请求转发提示
            request.setAttribute("msg","删除失败");
        }
        request.getRequestDispatcher(request.getContextPath() + "/index.jsp").forward(request,response);
    }
}
