package com.yinzifan.service.impl;

import java.util.List;
import java.util.Map;

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

	@Override
	public List<BlogInfoEntity> queryPageBlog(Map<String, Object> map) {
		return blogInfoDao.queryPageBlog(map);
	}

	@Override
	public Long queryPageTotal(Map<String, Object> map) {
		return blogInfoDao.queryPageTotal(map);
	} 
	
	@Override
	public BlogInfoEntity queryBlogInfoById(Integer id) {
		return blogInfoDao.queryBlogInfoById(id);
	}

	@Override
	public void updateBlogInfo(BlogInfoEntity entity) {
		blogInfoDao.updateBlogInfo(entity);
	}

	@Override
	public Integer insertBlog(BlogInfoEntity entity) {
		return blogInfoDao.insertBlog(entity);
	}

	@Override
	public BlogInfoEntity queryNextBlogInfo(Integer id) {
		return blogInfoDao.queryNextBlogInfo(id);
	}

	@Override
	public BlogInfoEntity queryLastBlogInfo(Integer id) {
		return blogInfoDao.queryLastBlogInfo(id);
	}

}
