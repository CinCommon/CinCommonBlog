package com.yinzifan.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yinzifan.dao.LinkDao;
import com.yinzifan.entity.LinkEntity;
import com.yinzifan.service.LinkService;

/**
* @author Cin
* @time 2018/01/25 23:02:26
*/
@Service("linkService")
public class LinkServiceImpl implements LinkService{
	@Autowired
	private LinkDao linkDao;
	@Override
	public List<LinkEntity> query(Map<String, Object> map) {
		return linkDao.query(map);
	}
	   /**
     * 查询所有友情链接的条数
     * Title: queryPageTotal
     * description:
     * @return
     */
    public Integer queryPageTotal() {
        return linkDao.queryPageTotal();
    }
}
