package cn.hx.myjpa.service;

import cn.hx.myjpa.pojo.User;
import cn.hx.myjpa.repository.UserOriginRepository;
import cn.hx.myjpa.repository.UserPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserOriginRepository userOriginRepository;
    @Autowired

    UserPageRepository userPageRepository;
    @Autowired
    PageRequest pageRequest;
    @Override
    @Cacheable(cacheNames = "user",key = "#ids")
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_UNCOMMITTED,readOnly = true)
    public User findUserById(Long ids) {
        return userOriginRepository.findUserById(ids);
    }

    @Override
    public List<User> getUserByPage(int page) {
        Page<User> result = userPageRepository.findAll(pageRequest.withPage(page));
        result.getContent().stream().forEach(user -> {
            System.out.println(user.toString());
        });
        return result.stream().toList();
    }

    @Override
    public Future<List<User>> getUserByIdLessThan(Long ids) {
        Future<List<User>> r = userOriginRepository.findAllByIdLessThan(ids);
        System.out.println("查询中----------------------");
        return r;
    }

    @Override
    public CompletableFuture<User> getUserByName(String name) {
        CompletableFuture<User> proxy = userOriginRepository.findUserByName(name);

        return proxy;
    }

}