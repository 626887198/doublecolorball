package com.baoding.dao;

import com.baoding.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,String> {
    User findByPhoneAndPassword(String phone, String password);

    User findByphone(String phone);
}
