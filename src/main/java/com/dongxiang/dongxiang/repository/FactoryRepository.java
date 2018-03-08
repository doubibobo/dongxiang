package com.dongxiang.dongxiang.repository;

import com.dongxiang.dongxiang.domain.FactoryManageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FactoryRepository extends CrudRepository<FactoryManageEntity, Long>{
    public List<FactoryManageEntity> findAll();
    public FactoryManageEntity findById(long id);

    public List<FactoryManageEntity> findByBreadNameLike(String breadName);
}
