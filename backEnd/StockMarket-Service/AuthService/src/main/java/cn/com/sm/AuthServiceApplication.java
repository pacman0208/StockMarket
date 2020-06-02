package cn.com.sm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @Auther: Lee
 * @Date: 5/9/2020 1:44 PM
 * @Software: IntelliJ IDEA
 * @Description:
 */
@SpringBootApplication
//@EnableAuthorizationServer
//@EnableResourceServer
public class AuthServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class,args);
    }
}
