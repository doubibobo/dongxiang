package com.dongxiang.dongxiang.repository;

import com.dongxiang.dongxiang.domain.UserManageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserManageEntity, Long>{
    /**
     * 根据用户名查找用户表中的记录,找寻密码权限等
     * @param pkUserId 用户登录名
     * @return 用户实体列表
     */
    public List<UserManageEntity> findByPkUserid(String pkUserId);
    public List<UserManageEntity> findAll();

    /**
     * 根据用户所在的羊场查询用户
     * @param userFactory
     * @return
     */
    public UserManageEntity findByUserFactory(String userFactory);

}
