package cn.hx.myjpa.repository;

import cn.hx.myjpa.pojo.NameOnly;
import cn.hx.myjpa.pojo.User;
import org.elasticsearch.action.ValidateActions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public interface UserOriginRepository extends Repository<User,Long> {
    User findUserById(Long id);
    Future<List<User>> findAllByIdLessThan(Long ids);
    CompletableFuture<User> findUserByName(String name);
    NameOnly findNameById(Long id);
    @Query("select u from User u where u.password=?1")
    User findByPassword(String password);
    @Query(value = "select * from user u where u.name like concat('%',?1,'%')",nativeQuery = true)
    List<User> findbyName(String name);
    @Query(value = "SELECT u from User u where u.id=:id")
    User queryUserById(@Param("id") Long id);
}
