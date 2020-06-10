package cn.com.sm.controller;

import cn.com.sm.service.AuthUserDetailService;
import cn.com.sm.service.UserService;
import cn.com.sm.util.ResultBody;
import cn.com.sm.util.ResultEnum;
import cn.com.sm.utils.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
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
    private static Logger LOG = LoggerFactory.getLogger(AuthController.class);

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

    @RequestMapping(value= {"/user"}, produces="application/json",method = RequestMethod.GET)
    public Map<String, Object> auth(OAuth2Authentication user){
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put(KEY_USER, user.getUserAuthentication());
        userInfo.put(KEY_AUTHORITIES, AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));

        return userInfo;
    }

    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "hello , you have been authorized!";
    }
    @PostMapping("/login")
    public ResultBody login(@RequestParam("username") String username , @RequestParam("password") String password){
//        UsersEntity user = uService.getUserByUsername(username);
//        if(user!=null ){//&& encoder.matches(password,user.getPassword())){
            // 1 创建UsernamePasswordAuthenticationToken

            Map<String , String> tokenMap = new HashMap<>();
            try{
                UsernamePasswordAuthenticationToken token
                        = new UsernamePasswordAuthenticationToken(username, password);
                // 2 认证
                Authentication authentication = authManager.authenticate(token);
                // 3 保存认证信息
                SecurityContextHolder.getContext().setAuthentication(authentication);
                // 4 加载UserDetails
                UserDetails details = authService.loadUserByUsername(username);

                // 5 生成自定义token
                String GenToken = TokenUtil.createToken(details);
                tokenMap.put("token",GenToken);
            }catch (BadCredentialsException e){
                LOG.error(e.getMessage());
                return ResultBody.error(ResultEnum.CUSTOM_USER_PWD_NOT_FOUND);
            }
            return ResultBody.success(tokenMap);
//        }
//        return ResultBody.error(ResultEnum.CUSTOM_USER_PWD_NOT_FOUND);
    }
}
