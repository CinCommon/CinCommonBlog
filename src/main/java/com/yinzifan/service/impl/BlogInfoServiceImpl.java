package com.yinzifan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yinzifan.dao.BlogInfoDao;
import com.yinzifan.entity.BlogInfoEntity;
import com.yinzifan.service.BlogInfoService;

/**
* @author Cin
* @time 2018/01/26 23:46:31
*/
@Service("blogInfoService")
public class BlogInfoServiceImpl  implements BlogInfoService{
	@Autowired
	private BlogInfoDao blogInfoDao;
	
	@Override
	public List<BlogInfoEntity> countCate() {
		return blogInfoDao.countCate();
	} 

}
