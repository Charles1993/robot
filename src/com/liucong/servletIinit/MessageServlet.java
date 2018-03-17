package com.liucong.servletIinit;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liucong.pojo.Message;



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
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("驱动加载成功");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("驱动加载失败");
		}
		Connection con=null;
		Statement st=null;
		try {
			//指定数据库连接编码，防止出错
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rebot?useUnicode=true&characterEncoding=utf-8", "liucong", "123");
			String sql="select * from message";
//			PreparedStatement ps=con.prepareStatement(sql);
			st=con.createStatement();
			ResultSet resultSet=st.executeQuery(sql);
			List<Message> messages_list=new ArrayList<Message>();
			while (resultSet.next()) {
				Message message=new Message();
				messages_list.add(message);
				message.setId(resultSet.getInt("id"));
				message.setCommand(resultSet.getString("command"));
				message.setContend(resultSet.getString("contend"));
				message.setDescrible(resultSet.getString("describle"));
				System.out.println((int)resultSet.getInt("id"));
				System.out.println((String)resultSet.getString("command"));
				System.out.println((String)resultSet.getString("contend"));
				System.out.println((String)resultSet.getString("describle"));
			}
			request.setAttribute("messages", messages_list);
			System.out.println("获取数据库连接成功");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("获取数据库连接失败");
			
			
			
		}finally {
			try {
				con.close();
				st.close();
				System.out.println("数据库连接关闭");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
