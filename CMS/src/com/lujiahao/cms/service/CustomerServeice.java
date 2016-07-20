package com.lujiahao.cms.service;

import com.lujiahao.cms.domain.Customer;

import java.util.List;

/**
 * Created by lujiahao on 2016/7/19.
 */
public interface CustomerServeice {

    /**
     * 添加客户
     * @param customer
     */
    public void addCustomer(Customer customer);

    /**
     * 编辑客户
     * @param customer
     */
    public void editCustomer(Customer customer);

    /**
     * 删除客户
     * @param id
     */
    public void deleteCustomer(String id);

    /**
     * 查询所有客户
     * @return
     */
    public List<Customer> findAllCustomer();

    /**
     * 根据id查询客户
     * @param id
     * @return
     */
    public Customer findCustomerById(String id);
}
