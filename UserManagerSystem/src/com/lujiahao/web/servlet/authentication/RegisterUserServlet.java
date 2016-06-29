package com.lujiahao.web.servlet.authentication;

import com.lujiahao.domain.User;
import com.lujiahao.service.UserService;
import com.lujiahao.service.impl.UserServiceImpl;
import com.lujiahao.utils.MyBeanUtils;
import com.lujiahao.web.bean.UserFormBean;

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
//            String id = request.getParameter("id");
//            String username = request.getParameter("username");
//            String password = request.getParameter("password");
//            String repassword = request.getParameter("repassword");
//            String gender = request.getParameter("gender");
//            String age = request.getParameter("age");
//
//            /**
//             * 数据校验
//             */
//            UserFormBean userFormBean = new UserFormBean(id,username,password,repassword,gender,age);
            UserFormBean userFormBean = MyBeanUtils.populate(UserFormBean.class,request.getParameterMap());
            if (!userFormBean.validate()){
                // 没有校验成功 表单中显示相应的信息
                request.setAttribute("userFormBean",userFormBean);// 提交数据,提示信息
                request.getRequestDispatcher("/pages/register.jsp").forward(request,response);
                return;
            }


            // 2.封装到User对象中
            //User user = new User(id, username, password, gender, age);
            User user = MyBeanUtils.populate(User.class,request.getParameterMap());

            // 3.执行注册方法
            UserService userService = new UserServiceImpl();
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
