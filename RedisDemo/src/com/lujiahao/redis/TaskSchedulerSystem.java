package com.lujiahao.redis;

import redis.clients.jedis.Jedis;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadFactory;

/**
 * 使用redis模拟任务调度
 * Created by lujiahao on 2016/7/7.
 */
public class TaskSchedulerSystem {

    /**
     * 模拟一个生产者
     */
    public static class TaskProducer implements Runnable {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        @Override
        public void run() {
            Random random = new Random();
            while (true) {
                try {
                    Thread.sleep(random.nextInt(600) + 600);
                    // 生成一个任务
                    UUID taskid = UUID.randomUUID();
                    // 将任务插入任务队列:task-queue
                    jedis.lpush("task-queue",taskid.toString());
                    System.out.println(taskid+"任务被插入");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 模拟一个消费者
     */
    public static class TaskConsumer implements Runnable{
        Jedis jedis = new Jedis("127.0.0.1",6379);
        @Override
        public void run() {
            Random random = new Random();
            while (true){
                try {
                    // 从任务队列中获取一个任务,并将任务放入暂存队列tmp-queue
                    jedis.rpoplpush("task-queue", "tmp-queue");

                    // 模拟处理任务--sleep---业务逻辑
                    Thread.sleep(1000);

                    // 模拟成功和失败的偶然情况
                    if (random.nextInt(13) % 7 == 0){
                        // 失败,将任务从暂存队列tmp-queue弹回到任务队列task-queue
                        String taskid = jedis.rpoplpush("tmp-queue", "task-queue");
                        System.out.println(taskid+"任务处理失败,弹回任务队列");
                    } else {
                        // 成功,将任务从暂存队列中清除
                        String taskid = jedis.rpop("tmp-queue");
                        System.out.println(taskid+"任务处理成功,从暂存队列中清除");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 启动一个生产者线程,产生模拟任务
        new Thread(new TaskProducer()).start();

        Thread.sleep(500);

        // 启动一个消费者线程,模拟任务的处理
        new Thread(new TaskConsumer()).start();

        // 让主线程休眠
        Thread.sleep(Integer.MAX_VALUE);
    }
}
