package com.excalibur.springboot.base.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: mingfa.zheng
 * @date: 2018/2/19 12:05
 */
public class SessionInfo implements Serializable {
    private static final long serialVersionUID = -2414700957833159618L;
    /** 用户id */
    private String userId;
    /** 用户编号 */
    private String userCode;
    /** 用户名称 */
    private String userName;
    /** 是否超级管理员 */
    private Boolean isSuperuser;
    /** 权限列表 */
    private Set<String> permissions = new HashSet<String>();
    /** 角色集合 */
    private Set<String> roles = new HashSet<String>();

    public SessionInfo() {
        super();
    }

    public SessionInfo(String userId, String userCode, String userName, Boolean isSuperuser) {
        super();
        this.userId = userId;
        this.userCode = userCode;
        this.userName = userName;
        this.isSuperuser = isSuperuser;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getSuperuser() {
        return isSuperuser;
    }

    public void setSuperuser(Boolean superuser) {
        isSuperuser = superuser;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public boolean hasPermission(String permission){
        if (isSuperuser) {
            return true;
        }
        return permissions.contains(permission);
    }

    public boolean hasRole(String role){
        if (isSuperuser){
            return true;
        }
        return roles.contains(role);
    }
}
