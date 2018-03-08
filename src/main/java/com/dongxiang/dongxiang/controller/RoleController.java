package com.dongxiang.dongxiang.controller;

//import com.dongxiang.dongxiang.WebSecurityConfig;
import com.dongxiang.dongxiang.domain.RoleUserEntity;
import com.dongxiang.dongxiang.repository.RoleRepository;
import com.dongxiang.dongxiang.response.message.Result;
import com.dongxiang.dongxiang.response.message.ResultUtils;
import com.dongxiang.dongxiang.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleService roleService;

    /**
     * 查看所有的角色
     * @return json数据返回所有角色
     */
    @GetMapping(value = "lists")
    @ResponseBody
    public List<RoleUserEntity> roleLists(@PageableDefault(page = 0, size = 10, sort = "id, desc")Pageable pageable) {
        List<RoleUserEntity> roleUserEntities = roleRepository.findAll();
        return roleUserEntities;
    }

    /**
     * 角色管理
     * @return
     */
    @GetMapping("role")
    public ModelAndView showAddRole() {
        List<RoleUserEntity> roleUserEntities = roleRepository.findAll();

        String viewName = "addRole";
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject("allRole", roleUserEntities);
        return modelAndView;
    }

    /**
     * 添加一个角色
     * @param roleUserEntity
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "")
    public Result addRole(@Valid RoleUserEntity roleUserEntity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtils.error("添加角色出错,请检查网络后重试", 201);
        } else {
            // 各个角色的名称,不能重复
            roleUserEntity.setTypeName(roleUserEntity.getTypeName());
            // 各个角色的代码,不能重复
            roleUserEntity.setPkTypeid(roleUserEntity.getPkTypeid());
            // 各个角色的默认权限
            roleUserEntity.setDefaultPermit(roleUserEntity.getDefaultPermit());
            roleUserEntity.setGmtCreate(new Timestamp(System.currentTimeMillis()));
            roleUserEntity.setGmtModified(new Timestamp(System.currentTimeMillis()));

            return ResultUtils.success("添加角色成功!", 202, roleRepository.save(roleUserEntity));
        }
    }

    /**
     * 根据权限的主键查找一个角色
     * @param id 主键
     * @return
     */
    @GetMapping(value = "/{id:\\d+}")
    public Result findRole(@PathVariable("id")Long id) {
        return ResultUtils.success("单个角色", 198, roleRepository.findOne(id));
    }

    /**
     * 删除一个角色
     * @param id
     */
    @DeleteMapping(value = "/{id:\\d+}")
    public void deleteRole(@PathVariable("id")Long id) {
        roleRepository.delete(id);
    }

    /**
     * 修改权限方法
     * @param id
     * @param pkTypeid
     * @param typeName
     * @param defaultPermit
     * @return
     */
    @PutMapping(value = "/{id:\\d+}")
    public Result roleUpdate(
            @PathVariable("id")Long id,
            @PathVariable("pkTypeid")Long pkTypeid,
            @PathVariable("typeName")String typeName,
            @PathVariable("defaultPermit")Long defaultPermit, BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return ResultUtils.error("修改角色失败", 195);
        }

        RoleUserEntity roleUserEntity = new RoleUserEntity();

        roleUserEntity.setDefaultPermit(defaultPermit);
        roleUserEntity.setTypeName(typeName);
        roleUserEntity.setPkTypeid(pkTypeid);
        roleUserEntity.setId(id);
        roleUserEntity.setGmtModified(new Timestamp(System.currentTimeMillis()));

        return ResultUtils.success("修改角色信息", 196, roleRepository.save(roleUserEntity));
    }
}
