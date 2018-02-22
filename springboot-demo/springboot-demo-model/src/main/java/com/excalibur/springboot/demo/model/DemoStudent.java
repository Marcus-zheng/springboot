package com.excalibur.springboot.demo.model;

import com.excalibur.springboot.base.model.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author: mingfa.zheng
 * @date: 2018/2/16 15:25
 */
@Entity
@Table(name = "demo_student")
public class DemoStudent extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 姓名 */
    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "code", length = 50)
    private String code;

    @Column(name = "gendex", length = 2)
    private String gender;

    public DemoStudent() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
