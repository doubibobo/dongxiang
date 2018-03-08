package com.dongxiang.dongxiang.controller;

import com.dongxiang.dongxiang.domain.PermitManageEntity;
import com.dongxiang.dongxiang.repository.PermitRepository;
import com.dongxiang.dongxiang.response.message.Result;
import com.dongxiang.dongxiang.response.message.ResultUtils;
import com.dongxiang.dongxiang.service.PermitService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class PermitController {
    @Autowired
    private PermitRepository permitRepository;
    @Autowired
    private PermitService permitService;

    /**
     * 权限管理
     * @return
     */
    @GetMapping(value = "/permit/permit")
    public ModelAndView showAddPermit() {
        List<PermitManageEntity> permitManageEntities = permitRepository.findAll();

        String viewName = "addPermit";
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject("addPermit", permitManageEntities);
        return modelAndView;
    }

    /**
     * 展示所有的权限,不更新新的页面
     * @return 展示所有权限的json格式
     */
    @GetMapping(value = "/permit/permitLists")
    @ResponseBody
    @JsonView(PermitManageEntity.PermitSimpleView.class)
    public List<PermitManageEntity> permitLists() {
        List<PermitManageEntity> permitManageEntities = permitRepository.findAll();
        return permitManageEntities;
    }

    /**
     * 添加一个权限
     * @param permitManageEntity
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/permit/addPermit")
    public Result addRole(@Valid PermitManageEntity permitManageEntity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtils.error("添加角色出错,请检查网络后重试", 201);
        } else {
            permitManageEntity.setPermitId(permitManageEntity.getPermitId());
            permitManageEntity.setGmtCreate(new Timestamp(System.currentTimeMillis()));
            permitManageEntity.setGmtModified(new Timestamp(System.currentTimeMillis()));
            System.out.println("添加权限成功!");
            return ResultUtils.success("添加权限成功!", 202, permitRepository.save(permitManageEntity));
        }
    }
}
