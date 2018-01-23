package com.yinzifan.entity;
/**
* @author Cin
* @time 2018年1月22日 下午9:54:35
*/
public class UserInfoEntity {

	private Integer id; // 主键
	private String userName; // 用户名
	private String password; // 密码
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserInfoEntity(Integer id, String userName, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}
	public UserInfoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
}
