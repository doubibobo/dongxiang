package com.dongxiang.dongxiang.repository;

import com.dongxiang.dongxiang.domain.RoleUserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<RoleUserEntity, Long>{
    public List<RoleUserEntity> findAll();

    /**
     * 根据角色的ID来获取角色名称
     * @param pkUserId
     * @return
     */
    public RoleUserEntity findByPkTypeid(long pkUserId);
}
