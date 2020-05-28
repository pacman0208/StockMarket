package cn.com.sm.service;

import cn.com.sm.entity.UsersEntity;
import cn.com.sm.repos.UserRepos;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthUserDetailService implements UserDetailsService {
    @Resource
    private UserRepos userRepos;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity user = userRepos.findUserByUsername(username);
        if(user!=null){
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            return new User(user.getUsername(),user.getPassword(),authorities);
        }
        throw new UsernameNotFoundException("User '" + username + "' not found.");
    }
}
