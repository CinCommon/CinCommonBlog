package com.yinzifan.service;

import java.util.List;

import com.yinzifan.entity.BlogTypeEntity;

/**
* @author Cin
* @time 2018/01/26 23:45:35
*/
public interface BlogTypeService {
	public List<BlogTypeEntity> countCate();
	public BlogTypeEntity queryBlogTypeById(Integer id);
}
