package cn.com.sm.service;

import cn.com.sm.entity.UsersEntity;

public interface UserService {
    Iterable<UsersEntity> getAllUsers();

    Iterable<UsersEntity> getUsersByNameAndPassword(String name,String password);

    UsersEntity getUserById(Integer id);

    UsersEntity registerUser(UsersEntity user);

    UsersEntity update(UsersEntity user);

    UsersEntity activateUser(int id) throws Exception;

    void deleteUser(int id);
}
