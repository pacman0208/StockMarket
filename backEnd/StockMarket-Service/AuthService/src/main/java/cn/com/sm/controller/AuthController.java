package cn.com.sm.controller;

import cn.com.sm.entity.UsersEntity;
import cn.com.sm.service.UserService;
import cn.com.sm.util.ResultBody;
import cn.com.sm.util.ResultEnum;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Lee
 * @Date: 5/9/2020 1:47 PM
 * @Software: IntelliJ IDEA
 * @Description:
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    private static final String KEY_USER = "user";
    private static final String KEY_AUTHORITIES = "authorities";

    @Resource
    private UserService uService;

    @RequestMapping(value= {"/user"}, produces="application/json")
    public Map<String, Object> auth(OAuth2Authentication user){
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put(KEY_USER, user.getUserAuthentication());
        userInfo.put(KEY_AUTHORITIES, AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));

        return userInfo;
    }
    @PostMapping("/login")
    public ResultBody login(@RequestParam("username") String username , @RequestParam("password") String password){
        Iterable<UsersEntity> it = uService.getUsersByNameAndPassword(username,password);
        if(it.iterator().hasNext()){
            return ResultBody.success(it.iterator().next());
        }
        return ResultBody.error(ResultEnum.valueOf("username/password invalidated."));
    }
}
