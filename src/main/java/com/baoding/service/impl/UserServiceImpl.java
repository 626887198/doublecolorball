package com.baoding.service.impl;

import com.baoding.bean.Note;
import com.baoding.bean.User;
import com.baoding.dao.UserDao;
import com.baoding.service.UserService;
import com.baoding.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService  {
    @Autowired
    private UserDao dao;
    private String salt = "#$%*&^*&(N?>";

    @Override
    public void doRegister(User user) {        //加盐加密
        String password = user.getPassword();
        user.setPassword(MD5Utils.encode(password,salt));
        dao.save(user);
    }

    @Override
    public User doLogin(String phone, String password) {
        password=MD5Utils.encode(password,salt);
        return dao.findByPhoneAndPassword(phone,password);
    }

    @Override
    public User findByPhone(String phone) {
        return dao.findByphone(phone);
    }


}
