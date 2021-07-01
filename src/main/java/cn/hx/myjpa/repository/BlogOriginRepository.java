package cn.hx.myjpa.repository;

import cn.hx.myjpa.pojo.BLogKey;
import cn.hx.myjpa.pojo.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogOriginRepository extends JpaRepository<Blog, BLogKey> {
}
