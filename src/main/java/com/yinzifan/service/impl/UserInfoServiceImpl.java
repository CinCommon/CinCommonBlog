package com.yinzifan.service.impl;
/**
* @author Cin
* @time 2018年1月22日 下午9:58:20
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yinzifan.dao.UserInfoDao;
import com.yinzifan.entity.UserInfoEntity;
import com.yinzifan.service.UserInfoService;
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService{

	@Autowired
	private UserInfoDao userInfoDao;
	
	@Override
	public UserInfoEntity queryUserInfoByUserName(String userName) {
		return userInfoDao.queryUserInfoByUserName(userName);
	}

	@Override
	public UserInfoEntity queryUserInfoDefault() {
		return userInfoDao.queryUserInfoDefault();
	}

}
