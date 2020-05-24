package cn.com.sm.repo;

import cn.com.sm.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepos extends JpaRepository<UsersEntity,Integer> {
    Iterable<UsersEntity> getUsersByUsernameAndPassword(String name,String password);


    @Modifying
    @Query(value="update users u set u.confirmed='1',u.last_chg_tsp=CURRENT_TIMESTAMP where id=?",nativeQuery=true)
    int activateUser(@Param("id")Integer id);



}
