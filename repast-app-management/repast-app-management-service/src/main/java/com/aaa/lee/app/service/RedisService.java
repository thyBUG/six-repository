package com.aaa.lee.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

/**
 * @ProjectName: repast-app-parent
 * @Package: com.aaa.lee.app.service
 * @ClassName: RedisService
 * @Author: Administrator
 * @Date: 2019/11/21 0021 21:44
 * @Version: 1.0
 */
@Service
public class RedisService {

    @Autowired
    private JedisCluster jedisCluster;

    /**
     * 从redis中取数据
     * @param key
     * @return
     */
    public String get(String key){
        return jedisCluster.get(key);
    }

    /**
     * 向redis中存数据
     * @param key
     * @param value
     * @return
     */
    public  String set(String key,String value){
        return jedisCluster.set(key, value);
    }

}
