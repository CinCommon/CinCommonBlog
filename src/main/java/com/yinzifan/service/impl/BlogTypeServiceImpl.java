package com.yinzifan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yinzifan.dao.BlogTypeDao;
import com.yinzifan.entity.BlogTypeEntity;
import com.yinzifan.service.BlogTypeService;

/**
* @author Cin
* @time 2018/01/26 23:48:00
*/
@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService {

	@Autowired
	private BlogTypeDao blogTypeDao;
	@Override
	public List<BlogTypeEntity> countCate() {
		return blogTypeDao.countCate();
	}
	@Override
	public BlogTypeEntity queryBlogTypeById(Integer id) {
		return blogTypeDao.queryBlogTypeById(id);
	}

	
}
