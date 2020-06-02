package cn.com.sm.controller;

import cn.com.sm.entity.UsersEntity;
import cn.com.sm.service.AuthUserDetailService;
import cn.com.sm.service.UserService;
import cn.com.sm.util.ResultBody;
import cn.com.sm.util.ResultEnum;
import cn.com.sm.util.TokenUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Resource
    private AuthUserDetailService authService;

    @Resource
    private AuthenticationManager authManager;

    @Resource
    private BCryptPasswordEncoder encoder;
    @RequestMapping(value= {"/user"}, produces="application/json")
    public Map<String, Object> auth(OAuth2Authentication user){
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put(KEY_USER, user.getUserAuthentication());
        userInfo.put(KEY_AUTHORITIES, AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));

        return userInfo;
    }
    @PostMapping("/login")
    public ResultBody login(@RequestParam("username") String username , @RequestParam("password") String password){
        String encode = encoder.encode(password);
        Iterable<UsersEntity> it = uService.getUsersByNameAndPassword(username,encode);
        if(it.iterator().hasNext()){
            UsersEntity user = it.iterator().next();
            // 1 创建UsernamePasswordAuthenticationToken


            System.out.println("encode pwd:"+encode);
            System.out.println("db pwd:"+user.getPassword());
            System.out.println("is pwd equal:"+encode.equals(user.getPassword()));
            UsernamePasswordAuthenticationToken token
                    = new UsernamePasswordAuthenticationToken(username, encode);
            // 2 认证
            Authentication authentication = authManager.authenticate(token);
            // 3 保存认证信息
            SecurityContextHolder.getContext().setAuthentication(authentication);
            // 4 加载UserDetails
            UserDetails details = authService.loadUserByUsername(username);

            // 5 生成自定义token
            String GenToken = TokenUtil.createToken(details);
            Map<String , String> tokenMap = new HashMap<>();
            tokenMap.put("token",GenToken);
            return ResultBody.success(tokenMap);
        }
        return ResultBody.error(ResultEnum.CUSTOM_USER_PWD_NOT_FOUND);
    }
}
