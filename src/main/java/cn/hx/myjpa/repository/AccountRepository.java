package cn.hx.myjpa.repository;

import cn.hx.myjpa.pojo.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
