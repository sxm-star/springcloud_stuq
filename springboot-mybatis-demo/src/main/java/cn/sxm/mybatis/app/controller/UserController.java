package cn.sxm.mybatis.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.sxm.mybatis.app.domain.User;
import cn.sxm.mybatis.app.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/likeName")
	public List<User> likeName(String name){
		return userService.likeName(name);
	}
	
}

//运行访问：http://127.0.0.1:8080/likeName?name=张三  就可以看到返回的数据了
