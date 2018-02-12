package com.yinzifan.service;

import java.util.List;
import java.util.Map;

import com.yinzifan.entity.BlogInfoEntity;

/**
* @author Cin
* @time 2018/01/26 23:45:27
*/
public interface BlogInfoService {
	public List<BlogInfoEntity> countCate();

	public List<BlogInfoEntity> queryPageBlog(Map<String, Object> map);

	public Long queryPageTotal(Map<String, Object> map);

	public BlogInfoEntity queryBlogInfoById(Integer id);

	public Integer updateBlogInfo(BlogInfoEntity entity);

	public Integer insertBlog(BlogInfoEntity entity);

	public BlogInfoEntity queryNextBlogInfo(Integer id);

	public BlogInfoEntity queryLastBlogInfo(Integer id);
	
	public Integer deleteBlogInfoById(Integer id);

}
