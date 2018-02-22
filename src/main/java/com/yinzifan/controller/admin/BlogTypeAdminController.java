package com.yinzifan.controller.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.yinzifan.entity.BlogTypeEntity;
import com.yinzifan.entity.PageBean;
import com.yinzifan.service.BlogTypeService;
import com.yinzifan.util.ResponseUtil;

/**
* @author Cin
* @time 2018/01/28 14:50:44
* 博客类别管理Controller
*/
@Controller
@RequestMapping("/admin/blogtype")
public class BlogTypeAdminController {
	@Autowired
	private BlogTypeService blogTypeService;
	private final static Logger LOGGER = LoggerFactory.getLogger(BlogTypeAdminController.class);
	
	@RequestMapping("queryPageBlogTypes")
	public void querypageBlogTypes(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows, BlogTypeEntity type, HttpServletResponse resp) throws IOException {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<BlogTypeEntity> lists = blogTypeService.queryPageBlogType(map);
		JSONObject json = new JSONObject();
		LOGGER.debug("BlogInfoEntity: {}", lists);
		json.put("rows", lists);
		json.put("total", blogTypeService.queryPageTotal());
		ResponseUtil.write(resp, json);
	}
}
