package cn.sxm.mybatis.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.sxm.mybatis.app.domain.User;
import cn.sxm.mybatis.app.mapper.UserMapper;

@Service
public class UserService {
	@Autowired
	private UserMapper userMappper;
	
    public List<User> likeName(String name){
        return userMappper.likeName(name);
    }
    
    
	@Transactional//添加事务.
	public void save(User demo){
		userMappper.save(demo);
	}
}

