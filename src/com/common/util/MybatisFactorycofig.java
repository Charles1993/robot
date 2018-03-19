/**
 * @Author: 刘聪
 * @descripe:MybatisFactorycofig.java
 * @gitconfig:   
 * @Date: Created in 2018-03-19 下午11:59:19
 * @Modified By:
 */
package com.common.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisFactorycofig {
	public static SqlSession getSqlSession() throws IOException {
		SqlSession session=null;
		Reader reader=null;
		reader = Resources.getResourceAsReader("com/config/mybatis/Config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		session=factory.openSession(true);
		return session;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
