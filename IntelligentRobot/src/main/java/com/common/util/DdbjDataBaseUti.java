/**
 * @Author: 刘聪
 * @descripe:DdbjDataBaseUti.java
 * @gitconfig:   
 * @Date: Created in 2018-03-18 下午10:15:29
 * @Modified By:
 */
package com.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DdbjDataBaseUti {
	public static final String DBMESSAGE="DBMESSAGE---------";
	static Connection con=null;
	public static Connection getConnect() {
		//驱动加载
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(DBMESSAGE+"驱动加载成功");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(DBMESSAGE+"驱动加载失败");
		}
		//指定数据库连接编码，防止出错
		try {
			con=DriverManager.getConnection("jdbc:mysql://47.106.103.51:3306/robot?useUnicode=true&characterEncoding=utf-8", "root", "123");
			System.out.println("获取数据库连接成功");
			return con;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("获取数据库连接失败");
		}
		return null;

	}
	/**test
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
