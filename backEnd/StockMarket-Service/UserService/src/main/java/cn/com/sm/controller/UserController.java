package cn.com.sm.controller;

import cn.com.sm.entity.UsersEntity;
import cn.com.sm.service.UserService;
import cn.com.sm.util.ResultBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
//@RequestMapping("/api/user")
public class UserController {
    @Resource
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public ResultBody register(UsersEntity user){
        UsersEntity result = userService.registerUser(user);
        return ResultBody.success(result);
    }

    @PutMapping
    public ResultBody update(UsersEntity user){
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
