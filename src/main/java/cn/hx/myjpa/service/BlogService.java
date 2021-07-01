package cn.hx.myjpa.service;

import cn.hx.myjpa.pojo.BLogKey;
import cn.hx.myjpa.pojo.Blog;

public interface BlogService {
    void save(Blog blog);
    Blog findOne(BLogKey bLogKey);
}
