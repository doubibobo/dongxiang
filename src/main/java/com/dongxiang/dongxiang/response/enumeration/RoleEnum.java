package com.dongxiang.dongxiang.response.enumeration;

/**
 * 用户的角色类型枚举类
 */
public enum RoleEnum {
    // 按照位来定义相关的权限
    TOTAL_SYSTEM_ADMINISTRATOR(524288, "系统总超级管理员"),
    DONGXIANG_FACTORY_ADMINISTRATOR(262144, "东翔公司管理员"),
    DONGXIANG_FACTORY_EXPERT(131072, "东翔公司专家"),
    DONGXIANG_FACTORY_TECHNICIAN(65536, "东翔公司技术员"),
    PROVINCE_AGENT_TOTAL_ADMINISTRATOR(32768, "省级代理超级管理员"),
    PROVINCE_AGENT_ADMINSTRATOR(16384, "省级代理管理员"),
    PROVINCE_AGENT_EXPERT(8192, "省级代理专家"),
    PROVINCE_AGENT_TECHNICIAN(4096, "省级代理技术员"),
    CITY_AGENT_TOTAL_ADMINISTRATOR(2048, "市级代理超级管理员"),
    CITY_AGENT_ADMINISTRATOR(1024, "市级代理管理员"),
    CITY_AGENT_EXPERT(512, "市级代理专家"),
    CITY_AGENT_TECHNICIAN(256, "市级代理技术员"),
    COUNTY_AGENT_TOTAL_ADMINISTRATOR(128, "县级代理超级管理员"),
    COUNTY_AGENT_ADMINISTRATOR(64, "县级代理管理员"),
    COUNTY_AGENT_EXPERT(32, "县级代理专家"),
    COUNTY_AGENT_TECHNICIAN(16, "县级代理技术员"),
    SHEEP_FARM_ADMINISTRATOR(8, "羊场管理员"),
    SHEEP_FARM_OPERATOR(4, "羊场操作员"),
    SHEEP_FARM_SUPERVISOR(2, "羊场监督员"),
    TOURIST(1, "游客")
    ;
    // 角色编号,前端的接口
    private Integer code;
    // 角色名称,一个编号对应一个角色,交付前端
    private String rolename;

    RoleEnum(Integer code, String rolename) {
        this.code = code;
        this.rolename = rolename;
    }

    public Integer getCode() {
        return code;
    }

    public String getRolename() {
        return rolename;
    }
}
