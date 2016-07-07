package com.lujiahao.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.Random;
import java.util.Set;

/**
 * LOL盒子英雄数据排行榜的模拟实现
 * Created by lujiahao on 2016/7/7.
 */
public class LOLHerosTopN {
    private static class PlayerTask implements Runnable {
        String[] heros = {"压缩", "剑圣", "蛮王", "男枪", "女警", "阿狸", "猴子", "赵信", "盖伦"};
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        @Override
        public void run() {
            Random random = new Random();
            while (true) {
                String hero = heros[random.nextInt(heros.length)];
                try {
                    Thread.sleep(1000);
                    jedis.zincrby("lol:hero:rank", 1, hero);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ViewerTask implements Runnable {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        int i = 1;
        @Override
        public void run() {
            while (true) {
                System.out.println("第"+i+"次获取榜单:");
                try {
                    Thread.sleep(2000);
                    Set<Tuple> herosAndScore = jedis.zrevrangeWithScores("lol:hero:rank", 0, -1);
                    for (Tuple tuple : herosAndScore) {
                        System.out.println(tuple.getElement()+":"+tuple.getScore());
                    }
                    i++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new PlayerTask()).start();

        Thread.sleep(1000);

        new Thread(new ViewerTask()).start();

        Thread.sleep(Long.MAX_VALUE);
    }
}
