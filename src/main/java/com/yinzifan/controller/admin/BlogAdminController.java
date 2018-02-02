package com.yinzifan.controller.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yinzifan.entity.BlogInfoEntity;
import com.yinzifan.entity.PageBean;
import com.yinzifan.service.BlogInfoService;
import com.yinzifan.util.ResponseUtil;
import com.yinzifan.util.StringUtil;

/**
* @author Cin
* @time 2018/01/28 14:50:44
*/
@Controller
@RequestMapping("/admin/blog")
public class BlogAdminController {
	@Autowired
	private BlogInfoService blogInfoService;
	private final static Logger LOGGER = LoggerFactory.getLogger(BlogAdminController.class);

	@RequestMapping("/insert")
	public void insertBlog(HttpServletRequest req, BlogInfoEntity blogInfo, HttpServletResponse resp)
			throws IOException {
		int resultTotal = 0;
		if (blogInfo.getId() == null) {
			resultTotal = blogInfoService.insertBlog(blogInfo);
		} else {

		}
		JSONObject result = new JSONObject();
		if (resultTotal > 0) {
			result.put("success", true);
		} else {
			result.put("success", false);
		}
		ResponseUtil.write(resp, result);
	}

	@RequestMapping("querypageBlogs")
	public void querypageBlogs(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows, BlogInfoEntity blog, HttpServletResponse resp,
			HttpServletRequest req) throws IOException {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<>();
		map.put("title", StringUtil.formatLike(blog.getTitle()));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<BlogInfoEntity> lists = blogInfoService.queryPageBlog(map);
		JSONObject json = new JSONObject();
		LOGGER.debug("BlogInfoEntity: {}", lists);
		json.put("rows", lists);
		json.put("total", blogInfoService.queryPageTotal(map));
		ResponseUtil.write(resp, json);
	}

}
