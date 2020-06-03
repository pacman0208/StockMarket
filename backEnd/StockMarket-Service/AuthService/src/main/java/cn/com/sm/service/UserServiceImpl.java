package cn.com.sm.service;

import cn.com.sm.entity.UsersEntity;
import cn.com.sm.repos.UserRepos;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Optional;

/**
 * User Service
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepos userRepos;


    /**
     * get user by username and password
     * @param name
     * @param password
     * @return
     */
    public  Iterable<UsersEntity> getUsersByNameAndPassword(String name, String password){
        return userRepos.getUsersByUsernameAndPassword(name,password);
    }

    @Override
    public UsersEntity getUserByUsername(String username) {
        return userRepos.findUserByUsername(username);
    }
}
