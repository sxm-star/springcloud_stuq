package cn.sxm.jpa.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.sxm.jpa.bean.User;
import cn.sxm.jpa.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="User2 API",description="用户API简单示例")
public class UserController2 {
	
	@Resource
	private UserService userService;
	
	
	
	
	@ApiOperation("获取单个用户")
	@RequestMapping(value="/v2/user",method=RequestMethod.GET)
	public User getUserByName(String name){
		return userService.findByName(name);
	}
	
	@ApiOperation("获取单个用户")
	@RequestMapping(value="/jql/user",method=RequestMethod.GET)
	public User getUserByJQLName(String name){
		return userService.findByName(name);
	}
	

	
}