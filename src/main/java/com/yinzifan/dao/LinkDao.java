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
}
