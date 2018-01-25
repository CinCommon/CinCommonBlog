package com.yinzifan.dao;

import com.yinzifan.entity.UserInfoEntity;

/**
* @author Cin
* @time 2018年1月22日 下午9:56:08
*/
public interface UserInfoDao {
	public UserInfoEntity queryUserInfoByUserName(String userName);
	public UserInfoEntity queryUserInfoDefault();
	
}
