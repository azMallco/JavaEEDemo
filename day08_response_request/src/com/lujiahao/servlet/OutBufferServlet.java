package com.lujiahao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 演示字节流
 * Created by lujiahao on 2016/11/22.
 */
public class OutBufferServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // response输出缓存8k大小
        System.out.println(response.isCommitted());
        for (int i = 0; i < 1024 * 8; i++) {
            response.getOutputStream().print("a");
        }
        System.out.println(response.isCommitted());
        //response.getOutputStream().print("a");
        System.out.println(response.isCommitted());
    }
}
