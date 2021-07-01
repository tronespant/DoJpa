package cn.hx.myjpa.pojo;

import lombok.Data;
import lombok.ToString;
import org.springframework.cache.annotation.EnableCaching;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "blog",schema = "user_log")
@IdClass(value = BLogKey.class)
@Data
@ToString
public class Blog {
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Id
    @Column(name = "title",nullable = false,length = 200)
    private String title;
    @Id
    @Column(name = "createUserId",nullable = false)
    private  Integer createUserId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blog blog = (Blog) o;
        return Objects.equals(id, blog.id) && Objects.equals(title, blog.title) && Objects.equals(createUserId, blog.createUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, createUserId);
    }
}
