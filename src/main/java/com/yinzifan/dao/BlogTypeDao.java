package com.yinzifan.dao;

import java.util.List;
import java.util.Map;

import com.yinzifan.entity.BlogTypeEntity;

/**
 * BlogType Dao层
* @author Cin
* @time 2018/01/26 23:44:51
*/
public interface BlogTypeDao {
	public List<BlogTypeEntity> countCate(); 
	public BlogTypeEntity queryBlogTypeById(Integer id);
	/**
	 * 根据条件检索BlogTypeEntity
	 * 其中条件有分页使用的(start, size), 主键(id)
	 * @param map
	 * @return
	 */
	public List<BlogTypeEntity> queryPageBlogType(Map<String, Object> map);
	/**
	 * 查询所有BlogTypeEntity的数量
	 * @return
	 */
	public Long queryPageTotal();
}
