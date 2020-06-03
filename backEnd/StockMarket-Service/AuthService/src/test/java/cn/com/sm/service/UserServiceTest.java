package cn.com.sm.service;

import cn.com.sm.entity.UsersEntity;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class UserServiceTest {
    private static Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Resource
    private UserService userService;

    @Test
    public void getUserByUserNameTest(){
//        Iterable<UsersEntity> it = userService.getUserByUserName("lee");
        System.out.println(userService.getUserByUsername("11"));
    }
}
