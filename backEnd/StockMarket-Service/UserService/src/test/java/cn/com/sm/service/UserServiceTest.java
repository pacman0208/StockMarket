package cn.com.sm.service;

import cn.com.sm.UserServiceApplication;
import cn.com.sm.entity.UsersEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;


@SpringBootTest(classes = UserServiceApplication.class)
public class UserServiceTest {

    @Resource
    private UserServiceImpl userService;

    @Test
    public void testGetAllUsers(){
        Iterable<UsersEntity> it = userService.getAllUsers();
        it.forEach(System.out::println);
    }

    @Test
    public void testGetUsersByNameAndPassword(){
        String username="lee";
        String pwd="123321";
        Iterable<UsersEntity> it =userService.getUsersByNameAndPassword(username,pwd);
        it.forEach(System.out::println);
    }

    @Test
    public void testGetUserById(){
        Integer id = 1;
        System.out.println(userService.getUserById(id));
    }

    @Test
    public void testRegisterUser(){
        UsersEntity user = new UsersEntity();
        user.setMobileNumber("13800138000");
        user.setEmail("aaa@qq.com");
        user.setConfirmed("0");
        user.setUsername("lee");
        user.setPassword("123321");
        user.setUserType("0");
        user.setCreateTsp(new Timestamp(new Date().getTime()));
        user.setLastChgTsp(new Timestamp(new Date().getTime()));
        System.out.println(userService.registerUser(user));
    }


    @Test
    public void testActivateUser(){
        int id=3;
        try {
            System.out.println(userService.activateUser(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
