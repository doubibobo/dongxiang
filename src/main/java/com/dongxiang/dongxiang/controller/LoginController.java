package com.dongxiang.dongxiang.controller;

//import com.dongxiang.dongxiang.WebSecurityConfig;
import com.dongxiang.dongxiang.domain.UserManageEntity;
import com.dongxiang.dongxiang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * 整个系统的根目录
     * @param account session中的username的值
     * @param model 模板
     * @return 返回对应的模板
     */
//    @GetMapping("/")
//    public String index(
//            @SessionAttribute(WebSecurityConfig.SESSION_KEY)
//            String account, Model model
//    ) {
//        return "index";
//    }

    /**
     * 用户登录界面展示
     * @return 返回用户登录的模板
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 用户登录的逻辑
     * @param username 用户名
     * @param password 密码
     * @param session session
     * @return 返回对应的模板,如果登录成功,则返回主页,如果登录失败,则返回到登录页面
     */
    @PostMapping("/loginVerify")
    public String loginVerify(String username, String password, HttpSession session) {
        UserManageEntity userManageEntity = new UserManageEntity();

        userManageEntity.setPkUserid(username);
        userManageEntity.setUserPwd(password);

        boolean verify = userService.verifyLogin(userManageEntity);

        if (verify) {
//            session.setAttribute(WebSecurityConfig.SESSION_KEY, username);
            return "index";
        } else {
            return "redirect:/login";
        }
    }

    /**
     * 退出登录的逻辑
     * @param session 用户session
     * @return 返回对应的模板, 如果退出成功, 返回登录的页面
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
//        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:/login";
    }
}
