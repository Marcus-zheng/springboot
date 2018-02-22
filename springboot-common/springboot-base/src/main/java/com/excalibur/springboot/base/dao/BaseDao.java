package com.excalibur.springboot.base.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * 自定义Repository的方法接口
 * (spring data jpa 通过创建方法名来做查询，只能做简单的查询，那如果我们要做复杂一些的查询呢，多条件分页怎么办，这里，spring data jpa为我们提供了JpaSpecificationExecutor接口)
 * @author: mingfa.zheng
 * @date: 2018/2/16 15:50
 * @param <T> 领域对象即实体类
 * @param <ID>领域对象的注解
 */
@NoRepositoryBean
public interface BaseDao<T,ID extends Serializable> extends JpaRepository<T,ID>,JpaSpecificationExecutor<T>{

    /**
     * 根据sql查询对应的Class类型集合
     * @author: mingfa.zheng
     * @date: 2018/2/16 15:50
     * @param target		实体类型
     * @param sql		查询sql
     */
    List<?> getItemsBySql(Class target, String sql);
}
