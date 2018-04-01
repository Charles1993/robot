package com.admin.dao;

import com.admin.pojo.User;
import com.common.util.DdbjDataBaseUti;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Duke
 * @Description:
 * @Date: Created in 下午11:25 2018/3/19
 * @Modified By:
 */
public class UserDao {

    public User findUserByUserName(String userName){
        User user = null;
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DdbjDataBaseUti.getConnect();
            String sql = "select * from User where userName = '" + userName + "'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("userName"));
                user.setPassWord(resultSet.getString("passWord"));
                user.setAccount(resultSet.getString("account"));
                user.setChineseName(resultSet.getString("chineseName"));
                user.setMobilePhone(resultSet.getString("mobilePhone"));
                user.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
                System.out.println("数据库关闭");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  user;
    }

    public List<User> findUsers(){
        List<User> users = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DdbjDataBaseUti.getConnect();
            String sql = "select * from User";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("userName"));
                user.setPassWord(resultSet.getString("passWord"));
                user.setAccount(resultSet.getString("account"));
                user.setChineseName(resultSet.getString("chineseName"));
                user.setMobilePhone(resultSet.getString("mobilePhone"));
                user.setEmail(resultSet.getString("email"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
                System.out.println("数据库关闭");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (users!=null && users.size()>=1){
            return users;
        } else {
            return null;
        }
    }
}
