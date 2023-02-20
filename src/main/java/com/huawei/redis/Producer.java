package com.huawei.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @DESCRIPTION:
 * @PACKAGE_NAME:QinRui
 * @CREATE_DATE:2023/2/20_星期一_0:19
 */
public class Producer {
    private String utf = "UTF-8";
    private Jedis jedis;
    private JedisPool pool;

    public Producer() {
        pool = RedisUntil.getJedisPool();
        jedis = pool.getResource();
    }

    public void provide(String channel, Message message) throws Exception {
        String str1 = MessageUtil.convertToString(channel, utf);
        String str2 = MessageUtil.convertToString(message, utf);
        jedis.publish(str1,str2);
    }

    public void close() throws Exception{
        // 将Jedis对象归还给线程池
        pool.returnResource(jedis);
    }
}
