package com.songxm.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.songxm.cloud.entity.User;
/**
 * @author: sxm
 * @ate: 17/5/29 23:19
 * @version: v1.0.0
 */
@RestController
public class MovieController {
    @Autowired
    RestTemplate restTemplate;

    @Value("${uc.provider.path}")
    private String remoteuri;
    /**
     * 电影服务调用用户会员服务
     * @param id
     * @return
     */
    @GetMapping("/movie/{uid}")
    public User findUserById(@PathVariable("uid") Long id){
       return this.restTemplate.getForObject(this.remoteuri + id,User.class);
    }
}
