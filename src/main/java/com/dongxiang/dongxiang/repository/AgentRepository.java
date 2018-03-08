package com.dongxiang.dongxiang.repository;

import com.dongxiang.dongxiang.domain.AgentFactoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentRepository extends CrudRepository<AgentFactoryEntity, Long> {
    public List<AgentFactoryEntity> findAll();
    public AgentFactoryEntity findById(int id);
}
