package cn.sxm.jpa.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import cn.sxm.jpa.bean.User;
import cn.sxm.jpa.repository.UserRepository;

/**
 * 
 * @author sxm
 *
 */
@Service
public class UserService {
	
	@Resource
	private UserRepository userRepository;
	
	/**
	 * save,update ,delete 方法需要绑定事务.
	 * 
	 * 使用@Transactional进行事务的绑定.
	 * 
	 * @param cat
	 */
	
	//保存数据.
	@Transactional
	public void save(User user){
		userRepository.save(user);
	}
	//批量保存
	@Transactional
	public void save(Iterable<User> users){
		userRepository.save(users);
	}
	
	//删除数据》
	@Transactional
	public void delete(int id){
		userRepository.delete(id);
	}
	//批量删除
	@Transactional
	public void delete(Iterable<User> users){
		userRepository.delete(users);
	}
	
	//查询数据.
	public Iterable<User> getAll(){
		return userRepository.findAll();
	}
	
	public User getUserById(Integer id){
		return userRepository.findOne(id);
	}
	
}
