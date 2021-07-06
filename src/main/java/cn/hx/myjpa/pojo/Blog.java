package cn.hx.myjpa.pojo;

import lombok.Data;
import lombok.ToString;
import org.springframework.cache.annotation.EnableCaching;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "blog",schema = "user_log")
@IdClass(value = BLogKey.class)
@Data
@ToString
public class Blog implements Serializable {
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Id
    @Column(name = "title",nullable = false,length = 200)
    private String title;
    @Id
    @Column(name = "createUserId",nullable = false)
    private  Long createUserId;
    @ManyToMany
    @JoinTable(
            name = "blog_tag_relation",
            joinColumns = @JoinColumn(name = "blog_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id",referencedColumnName = "id")
    )
    private List<Tag> tags;

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
