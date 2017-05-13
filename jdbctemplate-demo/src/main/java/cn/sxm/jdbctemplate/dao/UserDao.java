package cn.sxm.jdbctemplate.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.sxm.jdbctemplate.bean.User;

@Repository
public class UserDao {

	@Resource
	private JdbcTemplate jdbcTemplate;

	public User findName(String name){
		String sql = "select * from user where name=?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
		User user = jdbcTemplate.queryForObject(sql, new Object[]{name}, rowMapper);
		return user;
	}
	
	public User findName(Integer id){
		String sql = "select * from user where id=?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
		User user = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
		return user;
	}
}
