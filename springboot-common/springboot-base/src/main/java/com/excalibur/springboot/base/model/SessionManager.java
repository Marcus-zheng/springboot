package com.excalibur.springboot.base.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author: mingfa.zheng
 * @date: 2018/2/19 12:15
 */
@Component
public class SessionManager {

   // private static Map<String, SessionInfo> sessionInfoMap = new HashMap<String, SessionInfo>();
    @Value("${session.timeout:1800}")
    private int sessionTimeout;
    @Autowired
    private RedisTemplate<String, SessionInfo> sessionCache;

    /**
     * 检测是否登录
     * @author: mingfa.zheng
     * @date: $date $time
     * @return:
     */
    public boolean isAlreadyLogin(String key){
        return sessionCache.hasKey(key);
    }

    public SessionInfo getSession(String key) {
        return sessionCache.opsForValue().get(key);
    }

    /**
     * 更新会话缓存过期时间
     * @param key
     */
    public void setSessionExpire(String key){
        //30分钟
        sessionCache.expire(key, sessionTimeout, TimeUnit.SECONDS);
    }

    /**
     * 保存会话信息
     * @param sessionInfo
     */
    public void save(SessionInfo sessionInfo){

    }

    public void remove(String sessionId){
        sessionCache.delete(sessionId);
    }
}
