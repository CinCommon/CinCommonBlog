package com.yinzifan.entity;

import java.util.Date;

/**
* @author Cin
* @time 2018年1月22日 下午9:54:35
*/
public class UserInfoEntity {

	private Integer id; // 主键
	private String userName; // 用户名
	private String password; // 密码
	private String profile;
	private String imageURL;
	private String shortName;
	private String whatsup;
	private Date createDate;
	private String status;
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
	
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getWhatsup() {
		return whatsup;
	}
	public void setWhatsup(String whatsup) {
		this.whatsup = whatsup;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public UserInfoEntity(Integer id, String userName, String password, String profile, String imageURL,
			String shortName, String whatsup, Date createDate, String status) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.profile = profile;
		this.imageURL = imageURL;
		this.shortName = shortName;
		this.whatsup = whatsup;
		this.createDate = createDate;
		this.status = status;
	}
	public UserInfoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserInfoEntity [id=" + id + ", userName=" + userName + ", password=" + password + ", profile=" + profile
				+ ", imageURL=" + imageURL + ", shortName=" + shortName + ", whatsup=" + whatsup + ", createDate="
				+ createDate + ", status=" + status + "]";
	}
	
}
