package cn.hx.myjpa.pojo;

import javax.persistence.*;

@Entity
@Table(name = "blog_tag_relation")
public class BlogTagRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id", nullable = false)
    private Long blog_id;

    public Long getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(Long blog_id) {
        this.blog_id = blog_id;
    }

    public String getTag_id() {
        return tag_id;
    }

    public void setTag_id(String tag_id) {
        this.tag_id = tag_id;
    }

    @Column(name="tag_id",nullable = true)
    private String tag_id;

}
