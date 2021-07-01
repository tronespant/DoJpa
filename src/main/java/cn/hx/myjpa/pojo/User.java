package cn.hx.myjpa.pojo;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity(name = "User")
//TODO
@NamedStoredProcedureQuery(name = "User.plus1", procedureName = "plus1inout", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "arg", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "res", type = Integer.class) })
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;

}
