package com.lujiahao.web.servlet.edit;

import com.lujiahao.domain.User;
import com.lujiahao.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 修改用户信息
 * Created by lujiahao
 * Created at 2016/6/28 17:56
 */
public class EditUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 0.请求参数乱码
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        User user = new User(id, username, password, gender, age);

        UserService userService = new UserService();
        User userById = userService.editUser(user);// 成功返回修改好的user,没成功返回旧的user
        // 这里的逻辑和登录的逻辑十分相似
        if (userById != null) {
            // 修改成功 重定向到首页
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            // 修改失败 请求转发到消息页面
            request.setAttribute("msg", "修改失败,请重试");
            request.setAttribute("userById", userById);
            request.getRequestDispatcher("/pages/edit_user.jsp").forward(request, response);
        }
    }

    private boolean checkUser(User newUser, User userById) {
        if (newUser.getId().equals(userById.getId()) &&
                newUser.getUsername().equals(userById.getUsername()) &&
                newUser.getPassword().equals(userById.getPassword()) &&
                newUser.getGender().equals(userById.getGender()) &&
                newUser.getAge().equals(userById.getAge())) {
            return false;
        }
        return true;
    }
}
