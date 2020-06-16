package cn.com.sm.service;

import cn.com.sm.entity.UsersEntity;
import cn.com.sm.vo.UserVO;

import java.util.Optional;

public interface UserService {
    Iterable<UsersEntity> getAllUsers();

    Iterable<UsersEntity> getUsersByNameAndPassword(String name,String password);

    UsersEntity getUserByName(String username);

    UsersEntity getUserById(Integer id);

    UsersEntity registerUser(UserVO user);

    UsersEntity update(UserVO user);

    UsersEntity activateUser(int id) throws Exception;

    void deleteUser(int id);

    String loginCheck(String username,String password);

}
