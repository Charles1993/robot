package com.admin.service;

import com.admin.pojo.User;

import java.awt.*;

public interface UserService {

    public User findUser(int id);

    public User findUserByUserName(String userName);

    public User findUserByAccount(String account);

    public List findUsers();
}
