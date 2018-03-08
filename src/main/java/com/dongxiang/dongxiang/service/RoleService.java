package com.dongxiang.dongxiang.service;

import com.dongxiang.dongxiang.domain.PermitManageEntity;
import com.dongxiang.dongxiang.repository.PermitRepository;
import com.dongxiang.dongxiang.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermitService permitService;

    /**
     * 获取角色的固定权限, 通过位运算操作
     * @return
     */
    public Map findRolePermits(long id) {
        long permit = roleRepository.findByPkTypeid(id).getDefaultPermit();
        Map map = new HashMap();
        // 位运算基础
        long basic = 1;
        long result = 0;
        result = basic & permit;
        if (result == 0) {

        } else {
            map.put("1", permitService.findOneByPermitId(1).getPermitName());
        }

        for (int i = 2; i <= 64; i++) {
            basic <<= 1;
            result = basic & permit;
            if (Math.pow(2, i-1) == result) {
                map.put(i, permitService.findOneByPermitId(i).getPermitName());
            } else {

            }
        }

        return map;
    }

    /**
     * 查询用户的拓展权限并返回
     * @param map
     * @param permit
     * @return
     */
    public Map findExtendPermit(Map map, long permit) {
        // 位运算基础
        long basic = 1;
        long result = 0;
        result = basic & permit;
        if (result == 0) {

        } else {
            map.put("1", permitService.findOneByPermitId(1).getPermitName());
        }

        for (int i = 2; i <= 64; i++) {
            basic <<= 1;
            result = basic & permit;
            if (Math.pow(2, i-1) == result) {
                map.put(i, permitService.findOneByPermitId(i).getPermitName());
            } else {

            }
        }

        return map;
    }
}
