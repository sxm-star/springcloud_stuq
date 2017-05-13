package cn.sxm.jdbctemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.sxm.jdbctemplate.bean.User;
import cn.sxm.jdbctemplate.service.UserService;
import io.swagger.annotations.Api;

@RestController
@Api("User API jdbctemplate")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user/name",method=RequestMethod.GET)
	public User fetchUserByName(String name){
		return userService.findName(name);
	}
	@RequestMapping(value="/user/id",method=RequestMethod.GET)
	public User fetchUserByName(Integer id){
		return userService.findName(id);
	}
}
