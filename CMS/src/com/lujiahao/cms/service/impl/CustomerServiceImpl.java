package com.lujiahao.cms.service.impl;

import com.lujiahao.cms.dao.CustomerDao;
import com.lujiahao.cms.dao.impl.CustomerDaoImpl;
import com.lujiahao.cms.domain.Customer;
import com.lujiahao.cms.service.CustomerServeice;
import com.lujiahao.cms.utils.LStringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lujiahao on 2016/7/19.
 */
public class CustomerServiceImpl implements CustomerServeice{

    // 1.接口 = 类
    private CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public Customer login(Customer customer) {
        return customerDao.findByNameAndPwd(customer.getName(),customer.getPwd());
    }

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

    @Override
    public List<Customer> findAllCustomerWithCondition(Customer customer) {
        // 判断条件
        // 0.1 拼凑sql语句   where 1=1 保证后面可以拼凑sql语句
        // String condition = "select * from t_customer where 1=1";
        StringBuilder condition = new StringBuilder("select * from t_customer where 1=1 ");// builder效率比buffer高
        // 拼凑条件  List有序可重复   Set无序不可重复
        List<Object> paramsList = new ArrayList<>();

        // 1.姓名
        if (customer.getName() != null && !"".equals(customer.getName())) {
            condition.append("and name like ?");
            paramsList.add("%"+customer.getName()+"%");// like语句必须加上百分号
        }
        // 2.性别
        if (customer.getGender() != null && !"".equals(customer.getGender())) {
            condition.append("and gender = ?");
            paramsList.add(customer.getGender());
        }
        // 3.生日
        if (customer.getStartBirthday() != null && !"".equals(customer.getStartBirthday())) {
            condition.append("and birthday >= ?");
            paramsList.add(customer.getStartBirthday());
        }
        if (customer.getEndBirthday() != null && !"".equals(customer.getEndBirthday())) {
            condition.append("and birthday <= ?");
            paramsList.add(customer.getEndBirthday());
        }
        // 4.爱好
        if (customer.getPreference() != null && !"".equals(customer.getPreference())) {
            condition.append("and preference like ?");
            paramsList.add("%"+customer.getPreference()+"%");// like语句必须加上百分号
        }

        // 处理
        String sql = condition.toString();
        Object[] params = paramsList.toArray();
        return customerDao.findAll(sql,params);
    }
}
