package cn.sxm.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import cn.sxm.jpa.bean.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}