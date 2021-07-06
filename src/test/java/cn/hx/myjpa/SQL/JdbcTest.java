package cn.hx.myjpa.SQL;

import cn.hx.myjpa.pojo.*;
import cn.hx.myjpa.service.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTest {
    @Autowired
    UserService userService;
    @Autowired
    BlogService blogService;
    @Autowired
    AccountService accountService;
    @Autowired
    DepartmentService departmentService;
    @Resource
    TagService tagService;

    char[] chars="suka blyat 中州".toCharArray();
    Character[] chts=new Character[chars.length];
    @Test
    public void testDepa() throws ExecutionException, InterruptedException {
        DepartMent departMent=new DepartMent();

        departMent.setName("信息部");
        List<User> list = userService.getUserByIdLessThan(20L).get();
        if (list.size()>0&&!list.isEmpty()) {
            departMent.setUsers(list);
        }
        departmentService.save(departMent);


    }
    @Test
    public void testAcco(){
        /*User user=new User();
        user.setId(11L);
        Account account=new Account();
        account.setUsername("测试账户");
        account.setPasswd("1234");
        account.setUser(user);
        accountService.createNewAccount(account);*/
        print(accountService.findById(1L).getUser().getAccount().toString());
    }
    @Test
    public void testBlog(){
        String str = blogService.findOne(new BLogKey("首次测试blog", 11L)).toString();
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
    public void update(){
        DepartMent depart=new DepartMent();
        depart.setId(3L);
        depart.setName("工业部");
        User user=new User();
        user.setId(11L);
        user.setDepartMent(depart);

        userService.updateUser(user);
    }
    @Test
    public void tagTest(){

        Tag result = tagService.findById(6L);
        System.out.println(result.getBlogs().size());

    }

    @Test
    public void testAnno(){
        User user=userService.findUserById(11L);
        System.out.println(user.toString());
        User userT=new User();
        user.setId(11L);
        ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("id", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<User> example=Example.of(userT,matcher);

    }
}
