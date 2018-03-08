package com.dongxiang.dongxiang.controller;

import com.dongxiang.dongxiang.domain.UserManageEntity;
import com.dongxiang.dongxiang.response.message.Result;
import com.dongxiang.dongxiang.repository.UserRepository;
import com.dongxiang.dongxiang.response.message.ResultUtils;
import com.dongxiang.dongxiang.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping(value = "/common")
public class UserController {
//    private final static Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);
    @Autowired // 依赖注入
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    /**
     * 查找所有的用户列表
     * @return 返回所有的用户信息
     */
    @GetMapping(value = "/userList")
    @JsonView(UserManageEntity.UserSimpleView.class)
    public List<UserManageEntity> userList() {
        return userRepository.findAll();
    }

    /**
     * 查找单个用户
     * @param id 获取用户的信息
     * @return
     */
    @GetMapping(value = "/{id:\\d+}")
//    @JsonView(UserManageEntity.UserDetailView.class)
    public Result findOne(@PathVariable("id")Long id) {
        return ResultUtils.success("单个用户查询", 208, userService.findOneUser(id));
    }

    /**
     * 增加一个用户
     * @param userManageEntity
     * @param bindingResult
     * @return 返回相应的状态码
     */
    @PostMapping(value = "")
    public Result addStudent(@Valid UserManageEntity userManageEntity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtils.error("添加用户失败", 203);
        } else {
            // 添加用户的校验信息
            // 待添加的用户信息
            userManageEntity.setPkUserid(userManageEntity.getPkUserid());
            userManageEntity.setUserPwd(userManageEntity.getUserPwd());
            userManageEntity.setUserNum(userManageEntity.getUserNum());
            userManageEntity.setUserPic(userManageEntity.getUserPic());
            userManageEntity.setUserRealname(userManageEntity.getUserRealname());
            userManageEntity.setUserLocation(userManageEntity.getUserLocation());
            userManageEntity.setUserTelephone(userManageEntity.getUserTelephone());
            userManageEntity.setUserRemark(userManageEntity.getUserRemark());
            userManageEntity.setUserFactory(userManageEntity.getUserFactory());
            userManageEntity.setUserRole(userManageEntity.getUserRole());
            userManageEntity.setUserPermit(userManageEntity.getUserPermit());
            userManageEntity.setIsExtended(userManageEntity.getIsExtended());

            // 基本信息
            userManageEntity.setGmtCreate(new Timestamp(System.currentTimeMillis()));
            userManageEntity.setGmtModified(new Timestamp(System.currentTimeMillis()));

            return ResultUtils.success("添加用户成功", 204, userRepository.save(userManageEntity));
        }
    }

    /**
     * 修改用户
     * @param userManageEntity
     * @param bindingResult
     * @return
     */
    @PutMapping(value = "/{id:\\d+}")
    public Result modifyUser(@Valid @RequestBody UserManageEntity userManageEntity, @PathVariable("id") Long id,  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtils.error("修改信息有误", 209);
        } else {
            userManageEntity.setId(id);
            System.out.println(id);
            System.out.println(userManageEntity.getPkUserid());
            userManageEntity.setPkUserid(userManageEntity.getPkUserid());
            System.out.println(userManageEntity.getUserPwd());
            userManageEntity.setUserPwd(userManageEntity.getUserPwd());
            userManageEntity.setUserNum(userManageEntity.getUserNum());
            userManageEntity.setUserPic(userManageEntity.getUserPic());
            userManageEntity.setUserRealname(userManageEntity.getUserRealname());
            userManageEntity.setUserLocation(userManageEntity.getUserLocation());
            userManageEntity.setUserTelephone(userManageEntity.getUserTelephone());
            userManageEntity.setUserRemark(userManageEntity.getUserRemark());
            userManageEntity.setUserFactory(userManageEntity.getUserFactory());
            userManageEntity.setUserRole(userManageEntity.getUserRole());
            userManageEntity.setUserPermit(userManageEntity.getUserPermit());
            userManageEntity.setIsExtended(userManageEntity.getIsExtended());

            userManageEntity.setGmtCreate(userRepository.findOne(id).getGmtCreate());
            userManageEntity.setGmtModified(new Timestamp(System.currentTimeMillis()));

            return ResultUtils.success("修改用户成功", 210, userRepository.save(userManageEntity));
        }
    }

    /**
     * 删除一个用户
     * @param id 用户的主键
     * @return 返回相应的状态码
     */
    @RequestMapping(value = "/{id:\\d+}")
    public void deleteStudent(@PathVariable("id") long id) {
        userRepository.delete(id);
    }
}
