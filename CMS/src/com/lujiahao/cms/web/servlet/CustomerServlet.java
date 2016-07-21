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
import java.util.List;

/**
 * Created by lujiahao on 2016/7/19.
 */
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 0.乱码
        request.setCharacterEncoding("UTF-8");
        // 1.获得请求参数,标示位
        String method = request.getParameter("method");
        if ("add".equals(method)){
            add(request,response);
        } else if ("findAll".equals(method)){
            findAll(request,response);
        } else if ("preEdit".equals(method)){
            preEdit(request,response);
        } else if ("edit".equals(method)){
            edit(request,response);
        } else if ("findAllWithCondition".equals(method)){
            findAllWithCondition(request,response);
        }
    }

    /**
     * 查询所有--条件查询
     */
    protected void findAllWithCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 1.获得数据并封装
            Customer customer = LBeanUtils.populate(Customer.class,request.getParameterMap());
            // 2.通知service查询所有
            CustomerServeice customerServeice = new CustomerServiceImpl();
            List<Customer> allCustomer = customerServeice.findAllCustomerWithCondition(customer);

            // 3.显示
            // 存放到request作用域中--每一次查询都是新的数据
            request.setAttribute("allCustomer",allCustomer);
            request.setAttribute("customer",customer);
            // servlet到jsp中显示,一次请求需要使用请求转发
            request.getRequestDispatcher("/pages/show_all_condition.jsp").forward(request,response);
        } catch (Exception e){
            // 1.打印日志
            e.printStackTrace();
            // 2.请求转发到消息界面
            request.setAttribute("msg","查询失败,请稍后重试.");
            request.getRequestDispatcher("/pages/message.jsp").forward(request,response);
        }
    }

    /**
     * 修改数据
     */
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 1.获得数据并封装
            Customer customer = LBeanUtils.populate(Customer.class, request.getParameterMap());
            // 2.通知service查询详情
            CustomerServeice customerServeice = new CustomerServiceImpl();
            customerServeice.editCustomer(customer);
            // 3.显示数据
            request.setAttribute("msg","修改成功");
            request.getRequestDispatcher("/pages/message.jsp").forward(request,response);
        } catch (Exception e){
            // 1.打印日志
            e.printStackTrace();
            // 2.请求转发到消息界面
            request.setAttribute("msg","修改失败,请稍后重试.");
            request.getRequestDispatcher("/pages/message.jsp").forward(request,response);
        }
    }


    /**
     * 修改前回显数据,通过id查询数据
     * @param request
     * @param response
     */
    protected void preEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 1.获得数据并封装
            String id = request.getParameter("id");
            // 2.通知service查询详情
            CustomerServeice customerServeice = new CustomerServiceImpl();
            Customer customer = customerServeice.findCustomerById(id);
            // 3.显示数据
            request.setAttribute("customer",customer);
            request.getRequestDispatcher("/pages/show_one.jsp").forward(request,response);
        } catch (Exception e){
            // 1.打印日志
            e.printStackTrace();
            // 2.请求转发到消息界面
            request.setAttribute("msg","查询失败,请稍后重试.");
            request.getRequestDispatcher("/pages/message.jsp").forward(request,response);
        }
    }


    /**
     * 查询所有
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 1.获得数据并封装

            // 2.通知service查询所有
            CustomerServeice customerServeice = new CustomerServiceImpl();
            List<Customer> allCustomer = customerServeice.findAllCustomer();

            // 3.显示
            // 存放到request作用域中--每一次查询都是新的数据
            request.setAttribute("allCustomer",allCustomer);
            // servlet到jsp中显示,一次请求需要使用请求转发
            request.getRequestDispatcher("/pages/show_all.jsp").forward(request,response);
        } catch (Exception e){
            // 1.打印日志
            e.printStackTrace();
            // 2.请求转发到消息界面
            request.setAttribute("msg","查询失败,请稍后重试.");
            request.getRequestDispatcher("/pages/message.jsp").forward(request,response);
        }
    }

    /**
     * 添加用户
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 1.获得数据并封装
            Customer customer = LBeanUtils.populate(Customer.class,request.getParameterMap());
            // 2.通过service层方法添加
            CustomerServeice customerServeice = new CustomerServiceImpl();
            customerServeice.addCustomer(customer);
            // 3.添加成功,提示
            request.setAttribute("msg","添加成功");
            request.getRequestDispatcher("/pages/message.jsp").forward(request,response);
        } catch (Exception e){
            // 记录日志
            e.printStackTrace();
            // 不成功,提示
            request.setAttribute("msg","添加失败,请稍后重试");
            request.getRequestDispatcher("/pages/message.jsp").forward(request,response);
        }
    }
}
