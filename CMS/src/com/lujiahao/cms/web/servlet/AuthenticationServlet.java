package com.lujiahao.cms.web.servlet;

import com.lujiahao.cms.domain.Customer;
import com.lujiahao.cms.service.CustomerServeice;
import com.lujiahao.cms.service.impl.CustomerServiceImpl;
import com.lujiahao.cms.utils.LBeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理用户信息验证的Servlet
 * 登录
 * 注册
 * 忘记密码
 * Created by lujiahao on 2016/7/21.
 */
public class AuthenticationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 0.乱码解决
        request.setCharacterEncoding("UTF-8");
        // 1.获取要执行的操作
        String method = request.getParameter("method");
        if ("login".equals(method)){
            login(request,response);
        } else if ("logout".equals(method)){
            logout(request,response);
        }
    }

    /**
     * 注销
     */
    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获得登录信息
        Object loginCustomer = request.getSession().getAttribute("loginCustomer");
        if (loginCustomer != null) {
            request.getSession().removeAttribute("loginCustomer");// 注销登录
        }
        // 2. 重定向到登录页面
        response.sendRedirect(request.getContextPath()+"/pages/login/login.jsp");
    }

    /**
     * 登录操作
     */
    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // 1.获取数据并封装
        Customer customer = LBeanUtils.populate(Customer.class,request.getParameterMap());
        // 2.通知service进行登录
        CustomerServeice customerServeice = new CustomerServiceImpl();
        Customer loginCustomer = customerServeice.login(customer);

        // 3.处理
        if (loginCustomer != null) {
            // 成功  -- session记录登录状态,重定向到主页面
            // * session作用域保存数据
            request.getSession().setAttribute("loginCustomer",loginCustomer);
            response.sendRedirect(request.getContextPath() + "/pages/main/main.jsp");
        } else {
            // 不成功  --- request记录当次请求提示,请求转发到login.jsp 显示数据
            request.setAttribute("msg","用户名和密码不匹配");
            request.setAttribute("customer",customer);// 回显数据
            request.getRequestDispatcher("pages/login/login.jsp").forward(request,response);
        }
    }
}
