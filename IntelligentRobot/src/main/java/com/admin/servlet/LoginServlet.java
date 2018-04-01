package com.admin.servlet;

import com.admin.pojo.User;
import com.admin.service.UserService;
import com.admin.service.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


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
        boolean flag = false;
        Logger logger = Logger.getLogger(LoginServlet.class);
        logger.warn("userName: " +userName +" passWord :" +passWord);
        logger.debug(String.format("userName : %s password : %s",userName,passWord));
        UserService userService = new UserServiceImpl();
        User user = userService.findUserByUserName(userName);
        if (user != null) {
            if (userName.equals(user.getUserName()) && passWord.equals(user.getPassWord())){
                flag = true;
            }
        }
        if (flag){
            List<User> users = userService.findUsers();
            req.getSession().setAttribute("currentUser",user);
            req.setAttribute("currentUser",user);
            req.setAttribute("users",users);
            req.getRequestDispatcher("/WEB-INF/front/jsp/users.jsp").forward(req,resp);
        }else {
            req.getRequestDispatcher("/WEB-INF/front/jsp/login.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
