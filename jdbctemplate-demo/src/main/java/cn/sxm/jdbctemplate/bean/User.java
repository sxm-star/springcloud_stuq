package cn.sxm.jdbctemplate.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
* 如何持久化呢？
 * 
 * 1、使用@Entity进行实体类的持久化操作，当JPA检测到我们的实体类当中有
 * 
 * @Entity 注解的时候，会在数据库中生成对应的表结构信息。
 * 
 * 
 * 如何指定主键以及主键的生成策略？
 * 
 * 2、使用@Id指定主键.
 * @author: sxm
 * @date: 16/5/9 01:36
 * @version: v1.0.0
 */
@Data
@Entity //实体类持久化操作
public class User implements Serializable {
    @Id//指定主键
    @GeneratedValue(strategy = GenerationType.AUTO)   //指定主键的生成策略
    Integer id;
    String name;
    Integer age;
}
