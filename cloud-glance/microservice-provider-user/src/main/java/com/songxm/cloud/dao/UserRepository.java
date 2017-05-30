package com.songxm.cloud.dao;

import com.songxm.cloud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: sxm
 * @date: 16/11/29 22:21
 * @version: v1.0.0
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{
}
