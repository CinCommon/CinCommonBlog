package com.yinzifan.service;

import com.yinzifan.entity.UserInfoEntity;

/**
* @author Cin
* @time 2018年1月22日 下午9:57:55
*/
public interface UserInfoService {
	public UserInfoEntity queryUserInfoByUserName(String userName);
	public UserInfoEntity queryUserInfoDefault();
}
