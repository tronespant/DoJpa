package cn.hx.myjpa.SQL;

import cn.hx.myjpa.pojo.User;
import cn.hx.myjpa.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CompletableFuture;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTest {
    @Autowired
    UserService userService;
    char[] chars="suka blyat 中州".toCharArray();
    Character[] chts=new Character[chars.length];
    @Before
    public void before(){
        System.out.println(chars.length);
        for (int i=0;i<chars.length;i++){
            chts[i]=Character.valueOf(chars[i]);

        }
    }
    @Test
    public void test() throws InterruptedException {
        CompletableFuture<User> user = userService.getUserByName("dong");
        user.thenApplyAsync((entiy)->{
           return entiy.getId()+":日志记录成功";
        }).thenAccept((result)->{
            System.out.println(result);
        });

        System.out.println("suka");
        Thread.sleep(5000);



    }

}
