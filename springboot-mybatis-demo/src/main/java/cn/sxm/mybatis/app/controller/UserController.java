package cn.sxm.mybatis.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;

import cn.sxm.mybatis.app.domain.User;
import cn.sxm.mybatis.app.service.UserService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {
	@Autowired
	private UserService userService;

	// 运行访问：http://127.0.0.1:8080/likeName?name=张三 就可以看到返回的数据了
	@RequestMapping("/likeName")
	public List<User> likeName(String name) {
		return userService.likeName(name);
	}

	// 运行访问：http://127.0.0.1:8080/page/likeName?name=sxm&page=1&size=5
	// 就可以看到返回的数据了
	@RequestMapping("/page/likeName")
	@Cacheable("page.likeName")
	public List<User> likeNamePage(String name, int page, int size) {
		log.info("page:{},size:{}", page, size);
		PageHelper.startPage(page, size);
		return userService.likeName(name);
	}
	
	@RequestMapping("/save")
	public User save(){
		User demo = new User();
		demo.setName("sxm");
		demo.setAge(18);
		userService.save(demo);
		return demo;
	}

}
