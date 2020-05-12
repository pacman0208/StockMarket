package cn.com.sm.repo;

import cn.com.sm.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepos extends JpaRepository<UsersEntity,Integer> {
    public  Iterable<UsersEntity> getUsersByUsernameAndPassword(String name,String password);


}
