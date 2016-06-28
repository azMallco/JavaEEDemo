package com.lujiahao.web.servlet.find;

import com.lujiahao.domain.User;
import com.lujiahao.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 通过id查询用户详情
 * Created by lujiahao
 * Created at 2016/6/28 13:43
 */
public class FindUserByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获得请求参数id的值
        String id = request.getParameter("id");
        // 2.通过service查询用户
        UserService userService = new UserService();
        User user = userService.findUserById(id);

        // 3.使用请求转发显示数据
        // 3.1在request作用域中设置数据
        request.setAttribute("user",user);
        // 3.2请求转发到jsp
        request.getRequestDispatcher("/pages/show_detail.jsp").forward(request,response);
    }
}
