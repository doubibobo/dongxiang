package com.dongxiang.dongxiang.service;

import com.dongxiang.dongxiang.domain.PermitManageEntity;
import com.dongxiang.dongxiang.repository.PermitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermitService {
    @Autowired
    private PermitRepository permitRepository;

    /**
     * 根据权限的ID属性查找
     * @param permitId
     * @return
     */
    public PermitManageEntity findOneByPermitId(long permitId) {
        return permitRepository.findByPermitId(permitId);
    }
}
