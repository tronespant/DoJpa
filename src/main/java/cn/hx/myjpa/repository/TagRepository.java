package cn.hx.myjpa.repository;

import cn.hx.myjpa.pojo.Tag;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag,Long> {
    @Override
    @EntityGraph(value = "tag-blog")
    Optional<Tag> findById(Long aLong);
}
