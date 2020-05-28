package cn.com.sm.service;

import cn.com.sm.entity.UsersEntity;

public interface UserService {
    Iterable<UsersEntity> getUsersByNameAndPassword(String name, String password);

}
