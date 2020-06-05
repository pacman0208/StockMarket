package cn.com.sm.config;

import cn.com.sm.filter.TokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

@Configuration
public class MyAuthTokenConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    @Resource
    private TokenFilter myTokenFilter;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(myTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }


}
