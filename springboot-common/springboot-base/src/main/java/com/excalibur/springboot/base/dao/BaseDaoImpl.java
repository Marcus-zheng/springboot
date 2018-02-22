package com.excalibur.springboot.base.dao;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

/**
 * 自定义repository的方法接口实现类,该类主要提供自定义的公用方法
 * @author: mingfa.zheng
 * @date: 2018/2/16 15:50
 */
public class BaseDaoImpl<T,ID extends Serializable> extends SimpleJpaRepository<T,ID> implements BaseDao<T, ID> {
    /**
     * 持久化上下文
     */
    private final EntityManager entityManager;

    /**
     * 父类没有不带参数的构造方法，这里手动构造父类
     * @param domainClass
     * @param entityManager
     */
    public BaseDaoImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public List<?> getItemsBySql(Class target, String sql) {
        return null;
    }
}
