package cn.springboot.stuq.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author: sxm
 * @date: 16/4/18 01:23
 * @version: v1.0.0
 */
@Data
public class DemoDTO {
    String name ;
    Integer age;
    @JSONField(format = "yyyy-MM-dd HH:mm")   //解决返回时直接返回日期
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")  //解决请求报错
    Date createTime;

    @JSONField(deserialize = false)  //不想返回该字段信息,可以用这个注解的属性值
    String remark;
}
