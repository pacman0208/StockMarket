package cn.com.sm.controller;

import cn.com.sm.entity.UsersEntity;
import cn.com.sm.service.UserService;
import cn.com.sm.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity<UsersEntity> register(UsersEntity user){
        UsersEntity result = userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/update")
    public ResponseEntity<UsersEntity> update(UsersEntity user){
        UsersEntity result = userService.update(user);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/active/{id}")
    public ResponseEntity<UsersEntity> active(@PathVariable Integer id) throws Exception {
        UsersEntity user = userService.activateUser(id);
        return ResponseEntity.ok(user);
    }


}
