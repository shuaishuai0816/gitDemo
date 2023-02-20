package com.huawei.redis;

/**
 * @DESCRIPTION:
 * @PACKAGE_NAME:QinRui
 * @CREATE_DATE:2023/2/20_星期一_0:31
 */
public class redisMain {
    public static void main(String[] args) {
        Message message = new Message();
        message.setInfo("hello");
        message.setTitle("this is the first messagr");

        try {
            Producer producer = new Producer();
            Consumer consumer = new Consumer();
            producer.provide("chnl", message);
            consumer.consum("chnl");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
