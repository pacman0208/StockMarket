package cn.com.sm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Date;

@SpringBootApplication
@EnableJpaAuditing
public class UserServiceApplication {
    public static void main(String[] args) {
//        System.out.println(new Date());
        SpringApplication.run(UserServiceApplication.class,args);
    }

}
