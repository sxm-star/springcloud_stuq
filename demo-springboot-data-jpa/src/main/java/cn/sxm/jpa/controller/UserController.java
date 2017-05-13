package cn.sxm.jpa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.sxm.jpa.bean.User;
import cn.sxm.jpa.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Api(tags="User API",description="用户API简单示例")
@Slf4j
public class UserController {
	
	@Resource
	private UserService userService;
	@ApiOperation("保存用户")
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public String save(User user){
		userService.save(user);
		return "save ok.";
	}
	
	@ApiOperation("批量保存用户")
	@RequestMapping(value="/users",method=RequestMethod.POST)
	public String save(@RequestBody  ArrayList<User> users){
		log.info("users:{}",users);
		userService.save(users);
		return "save ok.";
	}
	@ApiOperation("删除用户")
	@RequestMapping(value="/user",method=RequestMethod.DELETE)
	public String delete(Integer id){
		userService.delete(id);
		return "delete ok";
	}

	@ApiOperation("用户列表")
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public Iterable<User> getAll(){
		return userService.getAll();
	}
	
	@ApiOperation("获取单个用户")
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public User getUserById(Integer id){
		return userService.getUserById(id);
	}
	

	
}