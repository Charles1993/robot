package com.liucong.message.servletIinit;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liucong.message.dao.MessageDao;
import com.liucong.message.pojo.Message;;



/**
 * Servlet implementation class MessageServlet
 */

public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MessageServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get网络请求，只能是通过ISO-8859-1，故要先对此解码,再解码为UTF-8
		String command=new String((request.getParameter("command")==null?"":request.getParameter("command")).getBytes("ISO-8859-1"),"UTF-8");
		String contend=new String((request.getParameter("contend")==null?"":request.getParameter("contend")).getBytes("ISO-8859-1"),"UTF-8");
		request.setAttribute("command", command);
		request.setAttribute("contend", contend);
		List<Message> messages_list=new MessageDao().queryMessagesList(command, contend);
		request.setAttribute("messages", messages_list);
		request.getRequestDispatcher("/WEB-INF/front/message/message.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
