package cn.com.sm.service;

import cn.com.sm.UserServiceApplication;
import cn.com.sm.entity.UsersEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest(classes = UserServiceApplication.class)
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testGetAllUsers(){
        Iterable<UsersEntity> it = userService.getAllUsers();
        it.forEach(System.out::println);
    }

    @Test
    public void testGetUsersByNameAndPassword(){
        String username="lee";
        String pwd="123";
        Iterable<UsersEntity> it =userService.getUsersByNameAndPassword(username,pwd);
        it.forEach(System.out::println);
    }

    @Test
    public void testGetUserById(){
        Integer id = 1;
        System.out.println(userService.getUserById(id));
    }
}
