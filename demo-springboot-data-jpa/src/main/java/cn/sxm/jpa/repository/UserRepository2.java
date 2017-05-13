package cn.sxm.jpa.repository;

import cn.sxm.jpa.bean.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


public interface UserRepository2 extends PagingAndSortingRepository<User,Integer>{

    /**
     * 1/ 查询方法 以 get | find | read 开头.
     * 2/ 涉及查询条件时，条件的属性用条件关键字连接，要注意的是条件属性以首字母大写。
     */

    //根据catName进行查询 : 根据catName进行查询.
    public User findByName(String name);

    /**
     * 如何编写JPQL语句，
     * Hibernate  -- HQL语句.
     * JPQL 语句 和HQL语句是类似的.
     */
    @Query(value = " from User where name=:cn")
    public User findMyUname(@Param("cn")String catName);
}
