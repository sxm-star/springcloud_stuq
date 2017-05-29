package com.songxm.cloud.controller;

import com.songxm.cloud.dao.UserRepository;
import com.songxm.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: sxm
 * @date: 16/11/29 22:24
 * @version: v1.0.0
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //@RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    @GetMapping("/user/{id}")
    public User findById(@PathVariable("id") Long id){
        return userRepository.findOne(id);
    }
}
