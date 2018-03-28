package com.yinzifan.dao;

import java.util.List;
import java.util.Map;

import com.yinzifan.entity.LinkEntity;

/**
* @author Cin
* @time 2018/01/25 22:57:33
*/
public interface LinkDao {

	public List<LinkEntity> query(Map<String, Object> map);
	/**
	 * 查询所有友情链接的条数
	 * Title: queryPageTotal
	 * description:
	 * @return
	 */
	public Integer queryPageTotal();
	
	/**
	 * @param map
	 * @return
	 */
	public Integer updateLink(LinkEntity linkEntity);
	
	/**
	 * @param map
	 * @return
	 */
	public Integer insertLink(LinkEntity linkEntity);
	/**
	 * @param id
	 * @return
	 */
	public Integer deleteLink(Integer id);
}
