package cn.sxm.mybatis.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.sxm.mybatis.app.domain.User;

public interface UserMapper {

	@Select("select *from User where name = #{name}")
	public List<User> likeName(String name);
	
	@Select("select *from User where id = #{id}")
	public User getById(long id);
	
	@Select("select name from User where id = #{id}")
	public String getNameById(long id);

}
