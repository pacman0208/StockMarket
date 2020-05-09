package cn.com.sm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Lee
 * @Date: 5/9/2020 1:47 PM
 * @Software: IntelliJ IDEA
 * @Description:
 */
@RestController
public class AuthController {
    @GetMapping("/hi")
    public String hi(){
        return "";
    }
}
