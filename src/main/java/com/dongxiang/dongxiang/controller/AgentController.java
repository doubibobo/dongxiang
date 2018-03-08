package com.dongxiang.dongxiang.controller;

import com.dongxiang.dongxiang.domain.AgentFactoryEntity;
import com.dongxiang.dongxiang.repository.AgentRepository;
import com.dongxiang.dongxiang.response.message.Result;
import com.dongxiang.dongxiang.response.message.ResultUtils;
import com.dongxiang.dongxiang.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping(value = "/agent")
public class AgentController {
    @Autowired
    private AgentRepository agentRepository;
    @Autowired
    private AgentService agentService;

    /**
     * 查找所有代理
     * @return
     */
    @GetMapping(value = "/lists")
    public List<AgentFactoryEntity> agentLists() {
        return agentRepository.findAll();
    }

    /**
     * 查找一个代理
     * @param id
     * @return
     */
    @GetMapping(value = "/{id:\\d+}")
    public Result findOne(@PathVariable("id") int id) {
        return ResultUtils.success("查询代理成功", 112, agentRepository.findById(id));
    }

    /**
     * 删除一个代理
     * @param id
     */
    @DeleteMapping(value = "/{id:\\d+}")
    public void deleteOne(@PathVariable("id") Long id) {
        agentRepository.delete(id);
    }

    /**
     * 添加一个代理
     * @param agentFactoryEntity
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/")
    public Result addOne(@Valid AgentFactoryEntity agentFactoryEntity, BindingResult bindingResult) {
        if (bindingResult.hasErrors())  {
            return ResultUtils.error("添加失败", 400);
        } else {
            agentFactoryEntity.setGmtCreate(new Timestamp(System.currentTimeMillis()));
            agentFactoryEntity.setGmtModified(new Timestamp(System.currentTimeMillis()));
            agentFactoryEntity.setAgentRank(agentFactoryEntity.getAgentRank());
            agentFactoryEntity.setAgentName(agentFactoryEntity.getAgentName());
            agentFactoryEntity.setAgentArea(agentFactoryEntity.getAgentArea());
            agentFactoryEntity.setAgentFather(agentFactoryEntity.getAgentFather());

            return ResultUtils.success("添加代理成功", 204, agentRepository.save(agentFactoryEntity));
        }
    }

    /**
     * 修改一个代理
     * @param agentFactoryEntity 代理实体
     * @param bindingResult 错误信息提示
     * @param id 代理主键
     * @return
     */
    @PutMapping("/{id:\\d+}")
    public Result agentUpdate(@Valid AgentFactoryEntity agentFactoryEntity, @PathVariable("id") int id,  BindingResult bindingResult) {
        if (bindingResult.hasErrors())  {
            return ResultUtils.error("添加失败", 400);
        } else {
            agentFactoryEntity.setId(id);

            agentFactoryEntity.setGmtCreate(agentRepository.findOne(new Long((long)id)).getGmtCreate());
            agentFactoryEntity.setGmtModified(new Timestamp(System.currentTimeMillis()));

            agentFactoryEntity.setAgentRank(agentFactoryEntity.getAgentRank());
            agentFactoryEntity.setAgentName(agentFactoryEntity.getAgentName());
            agentFactoryEntity.setAgentArea(agentFactoryEntity.getAgentArea());
            agentFactoryEntity.setAgentFather(agentFactoryEntity.getAgentFather());

            return ResultUtils.success("添加代理成功", 204, agentRepository.save(agentFactoryEntity));
        }
    }
}
