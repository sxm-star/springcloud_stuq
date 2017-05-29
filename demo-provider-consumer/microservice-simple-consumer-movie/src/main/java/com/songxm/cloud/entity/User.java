package com.songxm.cloud.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: sxm
 * @date: 16/11/30 00:25
 * @version: v1.0.0
 */
@Data
public class User {

    private Long id;
    private String username;
    private String name;
    private Short age;
    private BigDecimal balance;
}
