package com.lujiahao.cms;

import com.lujiahao.cms.domain.Customer;
import com.lujiahao.cms.service.CustomerServeice;
import com.lujiahao.cms.service.impl.CustomerServiceImpl;
import com.lujiahao.cms.utils.LBeanUtils;
import com.lujiahao.cms.utils.LStringUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lujiahao on 2016/7/21.
 */
public class TestClass {
    @Test
    public void addCustomer(){
        for (int i = 0; i < 100; i++) {
            Map<String,String[]> map = new HashMap<>();
            map.put("id",new String[]{LStringUtils.getUUID()});
            map.put("name",new String[]{"逗比"+LStringUtils.getUUID().substring(0,2)});
            map.put("gender",new String[]{"女"});
            map.put("birthday",new String[]{"1992-07-08"});
            map.put("cellphone",new String[]{"15613566958"});
            map.put("email",new String[]{"hahahaha"});
            map.put("preference",new String[]{"高尔夫,保龄球,斯诺克,网球,蹦极"});
            map.put("type",new String[]{"钻石会员"});
            map.put("description",new String[]{"随便写点描述"});

            Customer customer = LBeanUtils.populate(Customer.class, map);
            CustomerServeice customerServeice  = new CustomerServiceImpl();
            customerServeice.addCustomer(customer);
        }

    }
}
