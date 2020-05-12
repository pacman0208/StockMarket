package cn.com.sm.service;

import cn.com.sm.entity.UsersEntity;
import cn.com.sm.repo.UserRepos;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * User Service
 */
@Service
public class UserService {
    @Resource
    private UserRepos userRepos;

    /**
     * get all users entity
     * @return
     */
    public Iterable<UsersEntity> getAllUsers(){
        return userRepos.findAll();
    }


    /**
     * get user by username and password
     * @param name
     * @param password
     * @return
     */
    public  Iterable<UsersEntity> getUsersByNameAndPassword(String name,String password){
        return userRepos.getUsersByUsernameAndPassword(name,password);
    }

    /**
     * get user by id
     * @param id
     * @return
     */
    public UsersEntity getUserById(Integer id){
        Optional<UsersEntity> optional = userRepos.findById(id);

        return optional.isPresent()?optional.get():null;
    }
}
