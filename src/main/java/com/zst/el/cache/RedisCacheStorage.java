package com.zst.el.cache;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;


@Component("cacheStorage")
public class RedisCacheStorage implements ICacheStorage<String, Object> {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static ObjectMapper objectMapper = new ObjectMapper();
    /**
     * redis user key. add platform name, which can distinguish on different  platform
     */
    private static final String REDIS_USER_KEY_PREFIX = "session_id_dplus_boot_";

    @Override
    public void set(final String key, final Object value) {
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                try {
                    String v = objectMapper.writeValueAsString(value);
                    connection.set(key.getBytes(DEFAULT_CHARSET), v.getBytes(DEFAULT_CHARSET));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return null;
            }
        });
    }

    @Override
    public void setEx(final String key, final Object value, final long expire) {
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) {
                try {
                    String v = objectMapper.writeValueAsString(value);
                    String userKey =  REDIS_USER_KEY_PREFIX + key;
                    connection.setEx(userKey.getBytes(DEFAULT_CHARSET), expire, v.getBytes(DEFAULT_CHARSET));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
    }

    @Override
    public void setNx(final String key, final Object value) {
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) {
                try {
                    String v = objectMapper.writeValueAsString(value);
                    connection.setNX(key.getBytes(DEFAULT_CHARSET), v.getBytes(DEFAULT_CHARSET));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
    }

    @Override
    public void mSet(final Map<String, Object> values) {
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                for (Map.Entry<String, Object> entry : values.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    try {
                        String v = objectMapper.writeValueAsString(value);
                        connection.set(key.getBytes(DEFAULT_CHARSET), v.getBytes(DEFAULT_CHARSET));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                return null;
            }
        });
    }

    @Override
    public void mSetNX(final Map<String, Object> values) {
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                for (Map.Entry<String, Object> entry : values.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    try {
                        String v = objectMapper.writeValueAsString(value);
                        connection.setNX(key.getBytes(DEFAULT_CHARSET), v.getBytes(DEFAULT_CHARSET));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                return null;
            }
        });
    }

    @Override
    public <T> T get(final String key, Class<T> clazz) {
        String value = redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
            	String userKey =  REDIS_USER_KEY_PREFIX + key;
                byte[] result = connection.get(userKey.getBytes(DEFAULT_CHARSET));
                if (result != null) {
                    return new String(result, DEFAULT_CHARSET);
                }
                return null;
            }
        });
        try {
            if(!StringUtil.isNullOrEmpty(value)){
                return objectMapper.readValue(value, clazz);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Long del(final String... keys) {
        final long num = 0;
        redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                long num = 0;
                for (String key : keys) {
                    num += connection.del(key.getBytes(DEFAULT_CHARSET));
                }
                return num;
            }
        });
        return num;
    }

    @Override
    public Boolean exists(final String key) {
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.exists(key.getBytes(DEFAULT_CHARSET));
            }
        });
    }

    @Override
    public void destroy() throws Exception {
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }
}
