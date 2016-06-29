package com.lujiahao.web.servlet.find;

import com.lujiahao.domain.User;
import com.lujiahao.service.UserService;
import com.lujiahao.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 查询所有用户
 * Created by lujiahao
 * Created at 2016/6/27 10:17
 */
public class FindAllUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 2.service层对象实例
        UserService userService = new UserServiceImpl();
        List<User> allUser = userService.findAllUser();

        // 3.使用请求转发到show_findall.jsp界面显示数据
        // 3.1 将数据存放到request作用域中,一般存放是从小范围到大范围
        request.setAttribute("allUser",allUser);
        // 3.2 请求转发
        request.getRequestDispatcher("/pages/show_findall.jsp").forward(request,response);
    }
}
