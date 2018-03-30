/**
 * @Author: 刘聪
 * @descripe:MessageInterface.java
 * @gitconfig:   
 * @Date: Created in 2018-03-21 下午9:26:35
 * @Modified By:
 */
package com.liucong.message.dao;

import java.util.List;
import java.util.Map;

import com.common.BaseMethodInterfaces;
import com.liucong.message.pojo.Message;

public interface Imessagedao extends BaseMethodInterfaces<Message>{
	public abstract List<Message> queryMessagesList_mybaits(Map<String, Object> params);	
}
