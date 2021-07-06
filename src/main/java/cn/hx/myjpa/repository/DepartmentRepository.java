package cn.hx.myjpa.repository;

import cn.hx.myjpa.pojo.DepartMent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartMent,Long> {
}
