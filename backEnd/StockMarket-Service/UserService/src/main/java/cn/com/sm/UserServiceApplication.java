package cn.com.sm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class UserServiceApplication {
    public static void main(String[] args) {
//        System.out.println(new Date());
        SpringApplication.run(UserServiceApplication.class,args);
    }

}
