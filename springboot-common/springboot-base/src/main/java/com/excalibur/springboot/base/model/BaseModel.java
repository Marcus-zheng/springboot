package com.excalibur.springboot.base.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 基础模型通用属性字段
 *
 * @author: mingfa.zheng
 * @date: 2018/2/17 7:26
 */
@MappedSuperclass
public abstract class BaseModel {

    /**
     * id
     */
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "id", length = 50)
    protected String id;

    /**
     *  创建时间，不允许修改
     */
    @Column(name = "create_time", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)  //获取自己想要的格式类型（TIMESTAMP：yyyy-MM-dd hh:mm:ss 2016-12-07 11:47:58.697显示毫秒）
    protected Date createTime = new Date();

    /**
     * 创建人id，一般是系统登录用户id，不允许修改
     */
   /* @Column(name = "creater_id", updatable = false, length = 50)
    protected String createrId;*/

    /**
     *  最后更新时间
     */
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updateTime;

    public BaseModel(){
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
