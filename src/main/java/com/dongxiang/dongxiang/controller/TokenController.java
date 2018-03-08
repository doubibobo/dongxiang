package com.dongxiang.dongxiang.controller;

import com.dongxiang.dongxiang.authorization.annotation.Authorization;
import com.dongxiang.dongxiang.authorization.annotation.CurrentUser;
import com.dongxiang.dongxiang.domain.UserManageEntity;
import com.dongxiang.dongxiang.repository.UserRepository;
import com.dongxiang.dongxiang.response.message.Result;
import com.dongxiang.dongxiang.response.message.ResultUtils;
import com.dongxiang.dongxiang.token.TokenManager;
import com.dongxiang.dongxiang.token.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tokens")
public class TokenController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenManager tokenManager;
    @PostMapping
    public Result login(@RequestParam String username, @RequestParam String password) {
        Assert.notNull(username, "用户名不能为空");
        Assert.notNull(password, "密码不能为空");

        List<UserManageEntity> userManageEntity = userRepository.findByPkUserid(username);
        if (userManageEntity.size() == 0) {
            // 未注册用户
            return ResultUtils.error("未注册", 122);
        } else if (!userManageEntity.get(0).getUserPwd().equals(password)) {
            // 密码输入错误
            return ResultUtils.error("密码错误", 123);
        }

        // 登录成功, 生成一个token, 保存用户登录的状态
        TokenModel model = tokenManager.createToken(userManageEntity.get(0).getId());
        return ResultUtils.success("登录成功", 100, model);
    }
    @DeleteMapping
    @Authorization
    public Result logout(@CurrentUser UserManageEntity userManageEntity) {
        tokenManager.deleteToken(userManageEntity.getId());
        return ResultUtils.success("退出成功", 101, null);
    }
}
