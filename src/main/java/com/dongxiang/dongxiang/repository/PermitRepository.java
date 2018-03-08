package com.dongxiang.dongxiang.repository;

import com.dongxiang.dongxiang.domain.PermitManageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermitRepository extends CrudRepository<PermitManageEntity, Long>{
    public List<PermitManageEntity> findAll();
    public PermitManageEntity findByPermitId(long permitId);
}
