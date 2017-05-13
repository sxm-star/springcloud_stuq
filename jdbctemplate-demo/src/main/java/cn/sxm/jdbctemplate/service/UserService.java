package cn.sxm.jdbctemplate.service;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import cn.sxm.jdbctemplate.bean.User;
import cn.sxm.jdbctemplate.dao.UserDao;

@Service
public class UserService {
  
  @Resource
  private UserDao userDao;
  
	public User findName(String name){
		return userDao.findName(name);
	}
	
	public User findName(Integer id){
		return userDao.findName(id);
	}
}
