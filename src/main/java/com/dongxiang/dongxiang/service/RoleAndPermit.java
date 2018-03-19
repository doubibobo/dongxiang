package com.dongxiang.dongxiang.service;

/**
 * 获取用户的角色以及权限信息
 */
public class RoleAndPermit {
    Long role;
    byte extended;
    Long extendedPermit;

    public Long getExtendedPermit() {
        return extendedPermit;
    }

    public void setExtendedPermit(Long extendedPermit) {
        this.extendedPermit = extendedPermit;
    }

    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }

    public byte getExtended() {
        return extended;
    }

    public void setExtended(byte extended) {
        this.extended = extended;
    }
}