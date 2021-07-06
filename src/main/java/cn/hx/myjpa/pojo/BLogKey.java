package cn.hx.myjpa.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class BLogKey implements Serializable {
    private String title;
    private Long createUserId;
    public BLogKey(){}


    public BLogKey(String title, Long createUserId) {
        this.title = title;
        this.createUserId=createUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BLogKey bLogKey = (BLogKey) o;
        return Objects.equals(title, bLogKey.title) && Objects.equals(createUserId, bLogKey.createUserId);
    }

    @Override
    public int hashCode() {
        int result=title!=null?title.hashCode():0;
        result = 31 * result + (createUserId!=null?createUserId.hashCode():0);
        return Objects.hash(title, createUserId);
    }
}
