/**
 * @Author: 刘聪
 * @descripe:MessageService.java
 * @gitconfig:   
 * @Date: Created in 2018-03-20 下午8:17:45
 * @Modified By:
 */
package com.liucong.message.service;

import java.util.List;
import java.util.Map;

import com.liucong.message.dao.MessageDao;
import com.liucong.message.pojo.Message;

public class MessageService {
	public List<Message> queryMessagesList(Map<String, Object> params){
		List<Message> list=null;
		MessageDao dao=new MessageDao();
		list=dao.queryMessagesList_mybaits(params);
		return list;
	}


}
