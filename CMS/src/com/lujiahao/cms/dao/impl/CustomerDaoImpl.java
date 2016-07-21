package com.lujiahao.cms.dao.impl;

import com.lujiahao.cms.dao.CustomerDao;
import com.lujiahao.cms.domain.Customer;
import com.lujiahao.cms.exception.DaoException;
import com.lujiahao.cms.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * Created by lujiahao on 2016/7/19.
 */
public class CustomerDaoImpl implements CustomerDao {

    // 1.核心类  必须设置数据源
    private QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());

    @Override
    public void save(Customer customer) {
        try {
            String sql = "insert into t_customer(id,name,gender,birthday,cellphone,email,preference,type,description) values(?,?,?,?,?,?,?,?,?)";
            Object[] params = {customer.getId(),customer.getName(),customer.getGender(),
                    customer.getBirthday(),customer.getCellphone(),customer.getEmail(),
                    customer.getPreference(),customer.getType(),customer.getDescription()};
            runner.update(sql,params);
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    @Override
    public void update(Customer customer) {
        try {
            String sql = "update t_customer set name=?,gender=?,birthday=?,cellphone=?,email=?,preference=?,type=?,description=? where id=?";
            Object[] params = {customer.getName(),customer.getGender(),
                    customer.getBirthday(),customer.getCellphone(),customer.getEmail(),
                    customer.getPreference(),customer.getType(),customer.getDescription()
                    ,customer.getId()};
            int i = runner.update(sql, params);
            if (i < 0){
                throw new DaoException("更新数据不存在");
            }
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(String id) {
        try {
            String sql = "delete from t_customer where id=?";
            Object[] params = {id};
            runner.update(sql,params);
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    @Override
    public List<Customer> findAll() {
        try {
            String sql = "select * from t_customer";
            return runner.query(sql,new BeanListHandler<Customer>(Customer.class));
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    @Override
    public List<Customer> findAll(String sql, Object[] params) {
        try {
            return runner.query(sql,new BeanListHandler<Customer>(Customer.class),params);
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    @Override
    public Customer findById(String id) {
        try {
            String sql = "select * from t_customer where id=?";
            Object[] params = {id};
            return runner.query(sql,new BeanHandler<Customer>(Customer.class),params);
        } catch (Exception e){
            throw new DaoException(e);
        }
    }

    @Override
    public Customer findByNameAndPwd(String name,String pwd) {
        try {
            String sql = "select * from t_customer where name=? and pwd=?";
            Object[] params = {name,pwd};
            return runner.query(sql,new BeanHandler<Customer>(Customer.class),params);
        } catch (Exception e){
            throw new DaoException(e);
        }
    }
}
