package cn.hx.myjpa.pojo;

import org.springframework.beans.factory.annotation.Value;

/**
 * 返回对象中需要的属性
 */
public interface NameOnly {
    String getName();
    @Value("#{target.id+'  '+target.name+'  '+target.password}")
    String getFullInfo();
}
