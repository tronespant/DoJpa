package cn.hx.myjpa.pojo;

import javax.persistence.*;
import java.util.List;

@NamedEntityGraph(
        name = "tag-blog",
        attributeNodes = {
                @NamedAttributeNode("blogs")
        }
)
@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "blog_tag_relation",
            joinColumns = @JoinColumn(name = "tag_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "blog_id",referencedColumnName = "id")
    )
    private List<Blog> blogs;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
/*    @ManyToMany
    @JoinTable
    private List<Blog> blogList;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

}
