/**
 * @Author: 刘聪
 * @descripe:MessageService.java
 * @gitconfig:   
 * @Date: Created in 2018-03-20 下午8:17:45
 * @Modified By:
 */
package com.liucong.message.service;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.common.util.MybatisFactorycofig;
import com.liucong.message.dao.Imessagedao;
import com.liucong.message.pojo.Message;
public class MessageService {
	/**
	 * @service
	 * 根据条件查询message列表
	 * @param params
	 * @return
	 */
	public List<Message> queryMessagesList(Map<String, Object> params){
		List<Message> list=null;
		SqlSession session = null;
		try {
			session=MybatisFactorycofig.getSqlSession();
			 Imessagedao messagedao=session.getMapper(Imessagedao.class);
			list= messagedao.list(params);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
				
		}
		return list;
	}
	public Message queryMessageById(int id) {
		Message message=null;
		SqlSession session = null;
		try {
			session=MybatisFactorycofig.getSqlSession();
			message=session.getMapper(Imessagedao.class).queryById(id);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return message;
	}
	
	 


}
