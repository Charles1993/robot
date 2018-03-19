package com.admin.servlet;

import com.admin.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;


public class LoginServlet extends HttpServlet{

    public LoginServlet(){

    }
    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String passWord = req.getParameter("passWord");
        if(userName==null || "".equals(userName)){
            //req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req,resp);
        }
        User user = null;
        boolean flag = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("驱动加载成功");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("驱动加载失败");
        }
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/duke?useUnicode=true&characterEncoding=utf-8","duke","123456");
            String sql = "select * from User where userName = '" + userName + "'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("userName"));
                user.setPassWord(resultSet.getString("passWord"));
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

        if (user != null) {
            if (userName.equals(user.getUserName()) && passWord.equals(user.getPassWord())){
                flag = true;
            }
        }
        if (flag){
            req.getSession().setAttribute("currentUser",user);
            req.setAttribute("currentUser",user);
            //req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req,resp);
            req.getRequestDispatcher("/message.action").forward(req,resp);
        }else {
            req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
