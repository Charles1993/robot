package com.liucong.pojo;
/**
 * 表message 对应的实体类
 * @author liucong
 *
 */
public class Message {
	/**
	 * id 主键
	 */
	private int id;
	/**
	 * command 指令
	 */
	private String command;
	/**
	 * contend 内容
	 */
	private String contend;
	/**
	 * describle 描述
	 */
	private String describle;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getContend() {
		return contend;
	}
	public void setContend(String contend) {
		this.contend = contend;
	}
	public String getDescrible() {
		return describle;
	}
	public void setDescrible(String describle) {
		this.describle = describle;
	}
	
	

}
