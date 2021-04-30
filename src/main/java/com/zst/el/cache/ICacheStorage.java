package com.zst.el.cache;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.nio.charset.Charset;
import java.util.Map;


public interface ICacheStorage<K, V> extends InitializingBean, DisposableBean {
    Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    void set(K key, V value);


    void setEx(K key, V value, long expire);


    void setNx(K key, V value);


    void mSet(Map<K, V> values);


    void mSetNX(Map<K, V> values);


    <T> T get(final String key, Class<T> clazz);


    Long del(K... keys);


    Boolean exists(K key);
}
