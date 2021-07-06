package cn.hx.myjpa.repository;

import cn.hx.myjpa.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User,Long> {
}
