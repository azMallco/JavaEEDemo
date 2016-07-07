package com.lujiahao.redis;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by lujiahao on 2016/7/7.
 */
public class RedisTest {
    private Jedis jedis = null;

    @Before
    public void getJedis(){
        jedis = new Jedis("127.0.0.1",6379);
    }

    /**
     * 测试redis的string数据结构功能
     */
    @Test
    public void testString(){
        // 插入一条数据
        jedis.set("u001","lujiahao");
        // 获取一条数据
        String result = jedis.get("u001");
        System.out.println(result);

        System.out.println("----------------------------");

        // 插入多条数据
        jedis.mset("u002","lifan","u003","luxiaohao");
        // 获取多条数据
        List<String> results = jedis.mget("u001", "u002", "u003");
        for (String s : results) {
            System.out.println(s);
        }
    }

    /**
     * 测试redis的hash数据结构功能
     */
    @Test
    public void testHash(){
        // 加入一条hash数据到redis库中
        jedis.hset("cart:user0001","深入理解JVM","1");
        // 插入多条数据
        HashMap<String,String> productMap = new HashMap<>();
        productMap.put("SpringMVC从入门到放弃","2");
        productMap.put("高级JS宝典","2");
        jedis.hmset("cart:user0001",productMap);

        System.out.println("------------取出购物车中的商品及数量信息------------");
        // 获取所有的key-value
        Map<String, String> cartMap = jedis.hgetAll("cart:user0001");
        Set<Map.Entry<String, String>> entrySet = cartMap.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println(entry.getKey()+": "+entry.getValue());
        }

        System.out.println("------------取出购物车中的商品信息------------");
        Set<String> products = jedis.hkeys("cart:user0001");
        for (String product : products) {
            System.out.println(product);
        }
    }

    /**
     * 测试redis的set数据结构功能
     */
    @Test
    public void testSet(){
        jedis.sadd("jedis:set:key01","java","js","jquery","spring","struts");
        jedis.sadd("jedis:set:key02","python","c++","objectc","swift","go","js","java");

        System.out.println("---------交集---------");
        Set<String> sinter = jedis.sinter("jedis:set:key01", "jedis:set:key02");
        for (String s : sinter) {
            System.out.println(s);
        }

        System.out.println("---------并集---------");
        Set<String> sunion = jedis.sunion("jedis:set:key01", "jedis:set:key02");
        for (String s : sunion) {
            System.out.print(s+",");
        }

    }
}
