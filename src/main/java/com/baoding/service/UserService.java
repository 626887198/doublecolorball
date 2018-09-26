package com.baoding.service;

import com.baoding.bean.Note;
import com.baoding.bean.User;

public interface UserService {
    void doRegister(User user);

    User doLogin(String phone, String password);


    User findByPhone(String phone);
}
