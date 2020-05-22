package cn.com.sm.service;

import cn.com.sm.entity.UsersEntity;
import cn.com.sm.repo.UserRepos;
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

    /**
     * user register
     * @param user
     * @return
     */
    public UsersEntity registerUser(UsersEntity user){
        return userRepos.saveAndFlush(user);
    }

    /**
     * update user
     * @param user
     * @return
     */
    public UsersEntity update(UsersEntity user){
        return userRepos.save(user);
    }

    @Override
    @Transactional
    public UsersEntity activateUser(int id) throws Exception {
        int flag = userRepos.activateUser(id);
        if(flag==1){
            return getUserById(id);
        }
        throw new Exception("activate user failed..");
    }

    public void deleteUser(int id){
        userRepos.deleteById(id);
    }
}
