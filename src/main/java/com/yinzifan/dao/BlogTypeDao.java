package com.yinzifan.dao;

import java.util.List;

import com.yinzifan.entity.BlogTypeEntity;

/**
* @author Cin
* @time 2018/01/26 23:44:51
*/
public interface BlogTypeDao {
	public List<BlogTypeEntity> countCate(); 
	public BlogTypeEntity queryBlogTypeById(Integer id);
}
