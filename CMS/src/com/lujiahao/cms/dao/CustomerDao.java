package com.lujiahao.cms.dao;

import com.lujiahao.cms.domain.Customer;

import java.util.List;

/**
 * Created by lujiahao on 2016/7/19.
 */
public interface CustomerDao {

    /**
     * 添加
     * @param customer
     */
    public void save(Customer customer);

    /**
     * 更新
     * @param customer
     */
    public void update(Customer customer);

    /**
     * 删除
     * @param id
     */
    public void delete(String id);

    /**
     * 查询所有
     * @return
     */
    public List<Customer> findAll();

    /**
     * 通过Id查询
     * @param id
     * @return
     */
    public Customer findById(String id);
}
