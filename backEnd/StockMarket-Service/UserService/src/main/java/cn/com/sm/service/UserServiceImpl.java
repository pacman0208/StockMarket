package cn.com.sm.service;

import cn.com.sm.entity.UsersEntity;
import cn.com.sm.exception.StockException;
import cn.com.sm.utils.Constants;
import cn.com.sm.repo.UserRepos;
import cn.com.sm.utils.ResultEnum;
import cn.com.sm.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.Optional;

/**
 * User Service
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepos userRepos;

    @Resource
    private BCryptPasswordEncoder encoder;
    /**
     * get all users entity
     * @return
     */
    public Iterable<UsersEntity> getAllUsers(){
        return userRepos.findAll();
    }


    /**
     *
     * @param username
     * @param password
     * @return
     */
    public String loginCheck(String username,String password){
        UsersEntity user = userRepos.getUsersByUsername(username);
        if(user!=null){
            if(encoder.matches(password,user.getPassword())){
                return username;
            }
        }
        return "";
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
    public UsersEntity registerUser(UserVO user){
        if(!user.getPassword().equals(user.getConfirmPassword())){
            throw new StockException(ResultEnum.PASSWORD_NOT_MATCH);
        }
        UsersEntity ue = new UsersEntity();
        BeanUtils.copyProperties(user,ue);
        ue.setPassword(encoder.encode(user.getPassword()));
        ue.setUserType(Constants.USER_TYPE.USER.getType());
        ue.setConfirmed("0");

        return userRepos.saveAndFlush(ue);
    }

    /**
     * update user
     * @param user
     * @return
     */
    public UsersEntity update(UserVO user){
        if(!user.getPassword().equals(user.getConfirmPassword())){
            throw new StockException(ResultEnum.PASSWORD_NOT_MATCH);
        }
        UsersEntity dbU = getUserByName(user.getUsername());
        dbU.setPassword(user.getPassword());
        dbU.setEmail(user.getEmail());
        dbU.setMobileNumber(user.getMobileNumber());
        UsersEntity ue = new UsersEntity();
        BeanUtils.copyProperties(dbU,ue);
        ue.setPassword(encoder.encode(user.getPassword()));
        return userRepos.save(ue);
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

    @Override
    public UsersEntity getUserByName(String username) {
        return userRepos.getUsersByUsername(username);
    }


}
