package cn.hx.myjpa.service;

import cn.hx.myjpa.pojo.BLogKey;
import cn.hx.myjpa.pojo.Blog;
import cn.hx.myjpa.repository.BlogOriginRepository;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Log4j2
@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    BlogOriginRepository blogOriginRepository;
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_UNCOMMITTED,readOnly = false)
    public void save(Blog blog) {
        blogOriginRepository.save(blog);
        log.debug(blog.toString()+":  保存成功");
    }

    @Override
    public Blog findOne(BLogKey bLogKey) {

        return blogOriginRepository.getById(bLogKey);
    }
}
