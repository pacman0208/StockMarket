package cn.com.sm.controller;

import cn.com.sm.entity.UsersEntity;
import cn.com.sm.service.UserService;
import cn.com.sm.utils.Constants;
import cn.com.sm.utils.ResultBody;
import cn.com.sm.utils.ResultEnum;
import cn.com.sm.utils.TokenUtil;
import cn.com.sm.vo.UserVO;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
//@RequestMapping("/api/user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/admin/login")
    public ResultBody adminLogin(@RequestBody UsersEntity params){
        Map<String , String> tokenMap = new HashMap<>();
        String uName = userService.adminLoginCheck(params.getUsername(),params.getPassword());
        if(StringUtils.isEmpty(uName)){
            return ResultBody.error(ResultEnum.CUSTOM_USER_PWD_NOT_FOUND);
        }
        UsersEntity user = userService.getUserByName(uName);
        // generate token
        String GenToken = TokenUtil.createToken(user);
        tokenMap.put("token",GenToken);
        return ResultBody.success(tokenMap);
    }
    @PostMapping("/login")
    public ResultBody login(@RequestBody UsersEntity params){

        Map<String , String> tokenMap = new HashMap<>();
        String uName = userService.loginCheck(params.getUsername(),params.getPassword());
        if(StringUtils.isEmpty(uName)){
           return ResultBody.error(ResultEnum.CUSTOM_USER_PWD_NOT_FOUND);
        }
        UsersEntity user = userService.getUserByName(uName);
        // generate token
        String GenToken = TokenUtil.createToken(user);
        tokenMap.put("token",GenToken);
        return ResultBody.success(tokenMap);
    }

    @PostMapping
    public ResultBody register(@RequestBody UserVO user){
        UsersEntity result = userService.registerUser(user);
        return ResultBody.success(result);
    }

    @PutMapping
    public ResultBody update(UserVO user){
        UsersEntity result = userService.update(user);
        return ResultBody.success(result);
    }

    @GetMapping("active/{id}")
    public ResultBody active(@PathVariable Integer id) throws Exception {
        UsersEntity user = userService.activateUser(id);
        return ResultBody.success(user);
    }


    @GetMapping("/userList")
    public ResultBody userList(){
        Iterable<UsersEntity> users = userService.getAllUsers();
        return ResultBody.success(users);
    }

    @GetMapping("/{id}")
    public ResultBody userDetail(@PathVariable Integer id){
        return ResultBody.success(userService.getUserById(id));
    }

    @GetMapping
    public ResultBody user(HttpServletRequest request){
        String token = request.getHeader(Constants.AUTHORIZATION);
        logger.info("token:"+token);
        Integer id = new Integer(TokenUtil.getIdFromToken(token));
        return ResultBody.success(userService.getUserById(id));
    }
    @DeleteMapping
    public ResultBody deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResultBody.success();
    }
    @GetMapping("/callCompany")
    public ResultBody testRestTemplate(){
//        CompanyEntity company = restTemplate.getForObject("http://127.0.0.1:8882/api/company/detail/1", CompanyEntity.class);
//        ResponseEntity<ResultBody> resultEntity=restTemplate.getForEntity("http://127.0.0.1:8882/api/company/detail/1", ResultBody.class);
        ResponseEntity<ResultBody> resultEntity=restTemplate.getForEntity("http://stock/api/company/1", ResultBody.class);
        System.out.println("get company from user service:"+resultEntity.getBody());
        return ResultBody.success(resultEntity.getBody());
    }
}
