package cn.hx.myjpa.service;

import cn.hx.myjpa.pojo.NameOnly;
import cn.hx.myjpa.pojo.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.mail.MailParseException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public interface UserService {
    User findUserById(Long id);
    List<User> getUserByPage(int page);
    Future<List<User>> getUserByIdLessThan(Long ids);
    CompletableFuture<User> getUserByName(String name);
    NameOnly getNameById(Long ids);
    User sbypss(String pass);
    List<User> getBaseRoleUser(String name);
    User QueryUserById(Long id);
    Future<List<User>> queryAllByIdBefore(Long ids);
    int setFixedPasswordFor(Long id,String password);
    Integer getUserByProcedure(Integer ids);
    void updateUser(User user);

}
