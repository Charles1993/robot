/**
 * @Author: 刘聪
 * @descripe:MessageDao.java
 * @gitconfig:   
 * @Date: Created in 2018-03-18 下午10:39:05
 * @Modified By:
 */
package com.liucong.message.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.common.util.DdbjDataBaseUti;
import com.common.util.MybatisFactorycofig;
import com.liucong.message.pojo.Message;

public class MessageDao {
	public List<Message> queryMessagesList_jdbc(String command,String contend){
		StringBuffer sql= new StringBuffer("select * from message where 1=1");
		if (command!=null&!command.equals("")) {
			sql.append(" and command='"+command+"'");

		}
		if (contend!=null&!contend.equals("")) {
			sql.append(" and contend like '%"+contend+"%'");
		}
		Connection con=DdbjDataBaseUti.getConnect();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql.toString());
			ResultSet resultSet=ps.executeQuery();
			List<Message> messages_list=new ArrayList<Message>();
			while (resultSet.next()) {
				Message message=new Message();
				messages_list.add(message);
				message.setId(resultSet.getInt("id"));
				message.setCommand(resultSet.getString("command"));
				message.setContend(resultSet.getString("contend"));
				message.setDescrible(resultSet.getString("describle"));
			}
			return messages_list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		return null;
		
	}
	public List<Message> queryMessagesList_mybaits(Map<String, Object> params){
		SqlSession session=null;
		List<Message> messages = null;
		try {
			session = MybatisFactorycofig.getSqlSession();
			messages = session.selectList("message.queryMessageList",params);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			session.close();
		}
		return messages;
	}
}
