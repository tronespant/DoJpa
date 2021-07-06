package cn.hx.myjpa.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department",schema = "user_log")
@Setter
@Getter
public class DepartMent {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @TableGenerator(name = "id_generator",table = "generation_sequences",pkColumnName = "pk_name",pkColumnValue = "customer_id",
    valueColumnName = "pk_value",allocationSize = 50)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name",columnDefinition = "varchar(25) not null")
    private String name;
    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnoreProperties
    List<User> users;

    @Override
    public String toString() {
        return "DepartMent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
