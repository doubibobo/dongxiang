package com.dongxiang.dongxiang.enumeration;

/**
 * 用户的角色类型枚举类
 */
public enum RoleEnum {
    // 按照位来定义相关的权限
            TOTAL_SYSTEM_ADMINISTRATOR(524288, "total_system_administrator"),
       DONGXIANG_FACTORY_ADMINISTRATOR(262144, "dongxiang_factory_administrator"),
              DONGXIANG_FACTORY_EXPERT(131072, "dongxiang_factory_expert"),
          DONGXIANG_FACTORY_TECHNICIAN(65536, "dongxiang_factory_technician"),
    PROVINCE_AGENT_TOTAL_ADMINISTRATOR(32768, "province_agent_total_administrator"),
           PROVINCE_AGENT_ADMINSTRATOR(16384, "province_agent_administrator"),
                 PROVINCE_AGENT_EXPERT(8192, "province_agent_expert"),
             PROVINCE_AGENT_TECHNICIAN(4096, "province_agent_technician"),
        CITY_AGENT_TOTAL_ADMINISTRATOR(2048, "city_agent_total_administrator"),
              CITY_AGENT_ADMINISTRATOR(1024, "city_agent_administrator"),
                     CITY_AGENT_EXPERT(512, "city_agent_expert"),
                 CITY_AGENT_TECHNICIAN(256, "city_agent_technician"),
      COUNTY_AGENT_TOTAL_ADMINISTRATOR(128, "county_agent_total_administrator"),
            COUNTY_AGENT_ADMINISTRATOR(64, "county_agent_administrator"),
                   COUNTY_AGENT_EXPERT(32, "county_agent_expert"),
               COUNTY_AGENT_TECHNICIAN(16, "county_agent_technician"),
              SHEEP_FARM_ADMINISTRATOR(8, "sheep_farm_administrator"),
                   SHEEP_FARM_OPERATOR(4, "sheep_farm_operator"),
                 SHEEP_FARM_SUPERVISOR(2, "sheep_farm_supervisor"),
                               TOURIST(1, "tourist"),
                                OTHERS(0, "others")
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
