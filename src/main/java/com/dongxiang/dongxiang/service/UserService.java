package com.dongxiang.dongxiang.service;

import com.dongxiang.dongxiang.domain.AgentFactoryEntity;
import com.dongxiang.dongxiang.domain.FactoryManageEntity;
import com.dongxiang.dongxiang.domain.PermitManageEntity;
import com.dongxiang.dongxiang.domain.UserManageEntity;
import com.dongxiang.dongxiang.repository.AgentRepository;
import com.dongxiang.dongxiang.repository.FactoryRepository;
import com.dongxiang.dongxiang.repository.RoleRepository;
import com.dongxiang.dongxiang.repository.UserRepository;
import com.dongxiang.dongxiang.response.message.Result;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private FactoryRepository factoryRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleService roleService;

    // 保存用户的登录信息
    private List<UserManageEntity> user;

    /**
     * 用户登录在用户表中的可见信息
     */
    public class UserLogin {
        private long id;;                      // 用户表的主键
        private String pkUserid;               // 用户名
        private String userPwd;                // 密码
        private String userPic;                // 用户照片存储路径
        private Map userRole;                  // 用户角色
        private Map userPermit;                // 用户所具有的权限
        private Map userFactory;               // 用户所属羊场

        public Map getUserFactory() {
            return userFactory;
        }

        public void setUserFactory(Map userFactory) {
            this.userFactory = userFactory;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getPkUserid() {
            return pkUserid;
        }

        public void setPkUserid(String pkUserid) {
            this.pkUserid = pkUserid;
        }

        public String getUserPwd() {
            return userPwd;
        }

        public void setUserPwd(String userPwd) {
            this.userPwd = userPwd;
        }

        public String getUserPic() {
            return userPic;
        }

        public void setUserPic(String userPic) {
            this.userPic = userPic;
        }

        public Map getUserRole() {
            return userRole;
        }

        public void setUserRole(Map userRole) {
            this.userRole = userRole;
        }

        public Map getUserPermit() {
            return userPermit;
        }

        public void setUserPermit(Map userPermit) {
            this.userPermit = userPermit;
        }
    }

    /**
     * 验证用户登录的信息
     * @param userManageEntity 用户登录提交的实体
     * @return list.size()表示列表的大小,如果>0,则说明有该用户反之则没有该用户
     */
    public boolean verifyLogin(UserManageEntity userManageEntity) {
        // 根据用户的输入信息到数据库中进行查询,由于注册时候的限制,只能有一个相同用户名的用户,所以user的size的值一定为1
        user = userRepository.findByPkUserid(userManageEntity.getPkUserid());
        return user.size()>0;
    }

    public UserLogin findOneUser(long id) {
        UserManageEntity userManageEntity = userRepository.findOne(id);
        UserLogin userLogin = new UserLogin();
        Map map = new HashMap();
        Map mapper;
        Map mapperFactory = new HashMap();

        userLogin.setId(userManageEntity.getId());
        userLogin.setPkUserid(userManageEntity.getPkUserid());
        userLogin.setUserPic(userManageEntity.getUserPic());
        userLogin.setUserPwd(userManageEntity.getUserPwd());

        // 角色名称
        String roleName = roleRepository.findByPkTypeid(userManageEntity.getUserRole()).getTypeName();
        map.put("roleName", roleName);
        map.put("roleNum", userManageEntity.getUserRole());
        userLogin.setUserRole(map);

        mapper = roleService.findRolePermits(userManageEntity.getUserRole());

        // 判断是否有拓展权限
        if (userManageEntity.getIsExtended() == 0) {
            // 没有拓展权限
        } else {
            mapper = roleService.findExtendPermit(mapper, userManageEntity.getUserPermit());
        }

        userLogin.setUserPermit(mapper);

        int isFactory = userManageEntity.getIsFactory();
        long factoryId = userManageEntity.getUserFactory();

        // 判断客户的类型(代理(总公司)\羊场\游客)
        if (isFactory == 0) {
            // 代表羊场
            FactoryManageEntity factoryManageEntity = factoryRepository.findById(factoryId);
            mapperFactory.put("factoryNum", factoryManageEntity.getId());
            mapperFactory.put("factoryName",factoryManageEntity.getBreadName());
        } else if (isFactory == 1){
            // 代表代理
            int agentId = (int) factoryId;
            AgentFactoryEntity agentFactoryEntity = agentRepository.findById(agentId);
            mapperFactory.put("agentNum", agentFactoryEntity.getId());
            mapperFactory.put("agentName", agentFactoryEntity.getAgentName());
        }
        userLogin.setUserFactory(mapperFactory);
        return userLogin;
    }
}
