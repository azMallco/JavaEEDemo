package com.lujiahao.cms.service.impl;

import com.lujiahao.cms.dao.CustomerDao;
import com.lujiahao.cms.dao.impl.CustomerDaoImpl;
import com.lujiahao.cms.domain.Customer;
import com.lujiahao.cms.service.CustomerServeice;
import com.lujiahao.cms.utils.LStringUtils;

import java.util.List;

/**
 * Created by lujiahao on 2016/7/19.
 */
public class CustomerServiceImpl implements CustomerServeice{

    // 1.接口 = 类
    private CustomerDao customerDao = new CustomerDaoImpl();
    @Override
    public void addCustomer(Customer customer) {
        // 服务器端随机生成UUID
        customer.setId(LStringUtils.getUUID());
        customerDao.save(customer);
    }

    @Override
    public void editCustomer(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public void deleteCustomer(String id) {
        customerDao.delete(id);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerDao.findAll();
    }

    @Override
    public Customer findCustomerById(String id) {
        return customerDao.findById(id);
    }
}
