package cn.hx.myjpa.repository;

import cn.hx.myjpa.pojo.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserPageRepository extends PagingAndSortingRepository<User,Long> {
}
