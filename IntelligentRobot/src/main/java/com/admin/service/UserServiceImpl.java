package com.admin.service;

import com.admin.dao.UserDao;
import com.admin.pojo.User;

import java.util.List;


/**
 * @Author: Duke
 * @Description:
 * @Date: Created in 下午9:30 2018/3/19
 * @Modified By:
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {
        UserDao userDao = new UserDao();
        this.setUserDao(userDao);
    }

    @Override
    public User findUser(int id) {
        return null;
    }

    /**
     * @param userName
     * @return
     */
    @Override
    public User findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

    @Override
    public User findUserByAccount(String account) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public List<User> findUsers() {
        return userDao.findUsers();
    }
}
