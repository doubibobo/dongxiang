package com.dongxiang.dongxiang.controller;

import com.dongxiang.dongxiang.authorization.annotation.Permit;
import com.dongxiang.dongxiang.domain.FactoryManageEntity;
import com.dongxiang.dongxiang.repository.FactoryRepository;
import com.dongxiang.dongxiang.response.message.Result;
import com.dongxiang.dongxiang.response.message.ResultUtils;
import com.dongxiang.dongxiang.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping(value = "/factory")
public class FactoryController {
    @Autowired
    private FactoryRepository factoryRepository;
    @Autowired
    private FactoryService factoryService;

    /**
     * 查看所有羊场
     * @return
     */
    @Permit(modules = "factory", authorities = "select_factory")
    @GetMapping(value = "")
    public List<FactoryManageEntity> factoryLists() {
        return factoryRepository.findAll();
    }

    /**
     * 根据工厂的主键查询一个角色
     */
    @Permit(modules = "factory", authorities = "select_factory")
    @GetMapping(value = "/{id:\\d+}")
    public Result findFactory(@PathVariable("id") Long id) {
        return ResultUtils.success("单个工厂", 176, factoryRepository.findById((long)id));
    }

    /**
     * 根据工厂的主键删除一个角色
     * @param id
     */
    @Permit(modules = "factory")
    @DeleteMapping(value = "/{id:\\d+}")
    public void deleteFactory(@PathVariable("id") Long id) {
        factoryRepository.delete(id);
    }

    /**
     * 修改一个羊场
     * @param factoryManageEntity
     * @param id
     * @param bindingResult
     * @return
     */
    @Permit(modules = "factory")
    @PutMapping(value = "/{id:\\d+}")
    public Result factoryUpdate(@Valid @RequestBody FactoryManageEntity factoryManageEntity, @PathVariable("id") Long id , BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtils.error("羊场修改失败", 173);
        } else {
            factoryManageEntity.setId(id);
            factoryManageEntity.setGmtCreate(factoryRepository.findOne(id).getGmtCreate());
            factoryManageEntity.setGmtModified(new Timestamp(System.currentTimeMillis()));

            factoryManageEntity.setPkNumber(factoryManageEntity.getPkNumber());
            factoryManageEntity.setBreadName(factoryManageEntity.getBreadName());
            factoryManageEntity.setBreadLocation(factoryManageEntity.getBreadLocation());
            factoryManageEntity.setCreateTime(factoryManageEntity.getCreateTime());
            factoryManageEntity.setResponsiblePersonid(factoryManageEntity.getResponsiblePersonid());

            factoryManageEntity.setRemark(factoryManageEntity.getRemark());
            factoryManageEntity.setDisnfectP(factoryManageEntity.getDisnfectP());
            factoryManageEntity.setAgent(factoryManageEntity.getAgent());

            return ResultUtils.success("羊场修改成功", 174, factoryRepository.save(factoryManageEntity));
        }
    }

    /**
     * 增加一个工厂实体
     * @param factoryManageEntity
     * @param bindingResult
     * @return
     */
    @Permit(modules = "factory")
    @PostMapping(value = "/add")
    public Result addFactory(@Valid FactoryManageEntity factoryManageEntity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtils.error("添加失败", 132);
        } else {
            factoryManageEntity.setGmtCreate(new Timestamp(System.currentTimeMillis()));
            factoryManageEntity.setGmtModified(new Timestamp(System.currentTimeMillis()));

            factoryManageEntity.setPkNumber(factoryManageEntity.getPkNumber());
            factoryManageEntity.setBreadName(factoryManageEntity.getBreadName());
            factoryManageEntity.setBreadLocation(factoryManageEntity.getBreadLocation());
            factoryManageEntity.setCreateTime(factoryManageEntity.getCreateTime());
            factoryManageEntity.setResponsiblePersonid(factoryManageEntity.getResponsiblePersonid());

            factoryManageEntity.setRemark(factoryManageEntity.getRemark());
            factoryManageEntity.setDisnfectP(factoryManageEntity.getDisnfectP());
            factoryManageEntity.setAgent(factoryManageEntity.getAgent());
            return ResultUtils.success("添加用户成功", 204, factoryRepository.save(factoryManageEntity));
        }
    }
}
