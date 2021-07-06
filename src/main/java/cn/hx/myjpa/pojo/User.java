package cn.hx.myjpa.pojo;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@NamedEntityGraph(name = "User.departMent",attributeNodes = {
        @NamedAttributeNode("departMent")
})
@Data
@Entity(name = "User")
//TODO
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    @OneToOne(mappedBy = "user")
    private Account account;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)

    private DepartMent departMent;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '}';
    }
}
