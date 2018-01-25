package com.yinzifan.service;

import java.util.List;
import java.util.Map;

import com.yinzifan.entity.LinkEntity;

/**
* @author Cin
* @time 2018/01/25 23:01:21
*/	
public interface LinkService {
	public List<LinkEntity> query(Map<String, Object> map);
	
}
