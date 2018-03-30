package com.liucong.message.method;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liucong.message.pojo.Message;
import com.liucong.message.service.MessageService;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class SelectById
 */
@WebServlet("/QueryById")
public class QueryById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		if (id!=null) {
			response.setHeader("Content-type", "text/html;charset=UTF-8");
			Message message=new MessageService().queryMessageById(Integer.parseInt(id));
			System.out.print(message.toString());
			JSONObject object = JSONObject.fromObject(message);
			response.getWriter().append(object.toString());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
