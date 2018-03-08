package com.dongxiang.dongxiang.service;

import com.dongxiang.dongxiang.domain.FactoryManageEntity;
import com.dongxiang.dongxiang.repository.FactoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactoryService {
    @Autowired
    public FactoryRepository factoryRepository;

    /**
     * 根据羊场的名称对羊场进行模糊查询
     * @param name
     * @param pageable
     * @return
     */
    public List<FactoryManageEntity> listFactoryByNameLike(String name, Pageable pageable) {
        // 进行模糊查询
        name = "%" + name + "%";
        List<FactoryManageEntity> factoryManageEntities = factoryRepository.findByBreadNameLike(name);
        return factoryManageEntities;
    }
}
