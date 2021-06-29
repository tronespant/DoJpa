package cn.hx.myjpa.repository;

import cn.hx.myjpa.pojo.User;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public interface UserOriginRepository extends Repository<User,Long> {
    User findUserById(Long id);
    Future<List<User>> findAllByIdLessThan(Long ids);
    CompletableFuture<User> findUserByName(String name);
}
