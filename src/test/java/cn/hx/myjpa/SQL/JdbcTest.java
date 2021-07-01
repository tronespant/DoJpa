package cn.hx.myjpa.SQL;

import cn.hx.myjpa.pojo.BLogKey;
import cn.hx.myjpa.pojo.Blog;
import cn.hx.myjpa.pojo.NameOnly;
import cn.hx.myjpa.pojo.User;
import cn.hx.myjpa.service.BlogService;
import cn.hx.myjpa.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTest {
    @Autowired
    UserService userService;
    @Autowired
    BlogService blogService;
    char[] chars="suka blyat 中州".toCharArray();
    Character[] chts=new Character[chars.length];
    @Test
    public void testBlog(){
        String str = blogService.findOne(new BLogKey("首次测试blog", 11)).toString();
        print(str);
   /*     Blog blog = new Blog();
        blog.setId(0L);
        blog.setTitle("首次测试blog");
        blog.setCreateUserId(11);
        blogService.save(blog);*/
    }
    public void print(String str){
        System.out.println(str);
    }
    @Before
    public void before(){
     /*   System.out.println(chars.length);
        for (int i=0;i<chars.length;i++){
            chts[i]=Character.valueOf(chars[i]);

        }*/
    }
    /*   CompletableFuture<User> user = userService.getUserByName("dong");
        user.thenApplyAsync((entiy)->{
           return entiy.getId()+":日志记录成功";
        }).thenAccept((result)->{
            System.out.println(result);
        });

        System.out.println("suka");
        Thread.sleep(5000);*/
    @Test
    public void test() throws InterruptedException {
        NameOnly result = userService.getNameById(11L);
        System.out.println(result.getFullInfo());
    }

    @Test
    public void testAnno(){
        System.out.println(userService.getUserByProcedure(12));

    }
}
