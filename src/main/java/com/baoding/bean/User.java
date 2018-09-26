package com.baoding.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Data
public class User {
    //用户的编号  auto_increment : 1,2,3,4,5,6....  i
    @Id
    private String uid;
    //用户密码
    private String password;
    //用户名
    private String username;
    //手机号码
    private String phone;
    //用户的头像
    private String headimg;
    //用户的状态:0 未激活, 1,已激活, 2: 已封号
    private Integer state;
    // 账户余额
    private double money;
}
