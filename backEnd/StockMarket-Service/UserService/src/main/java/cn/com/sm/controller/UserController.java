package cn.com.sm.controller;

import cn.com.sm.entity.UsersEntity;
import cn.com.sm.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/hi")
    public Iterable<UsersEntity> hi(){
        Iterable<UsersEntity> it = userService.getAllUsers();
        it.forEach(System.out::println);
        return it;
    }
}
