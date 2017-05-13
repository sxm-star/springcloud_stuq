package cn.sxm.mybatis.app.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable{
   private String name;
   private Integer age;
   private Integer id;
}
