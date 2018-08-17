package com.yinzifan.controller.admin;

import java.io.IOException;
import java.util.Arrays;
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
import com.yinzifan.entity.BlogInfoEntity;
import com.yinzifan.entity.PageBean;
import com.yinzifan.service.BlogInfoService;
import com.yinzifan.util.ResponseUtil;
import com.yinzifan.util.StringUtil;

/**
* @author Cin
* @time 2018/01/28 14:50:44
* 博客管理Controller
*/
@Controller
@RequestMapping("/admin/blog")
public class BlogAdminController {
	@Autowired
	private BlogInfoService blogInfoService;
	private final static Logger LOGGER = LoggerFactory.getLogger(BlogAdminController.class);

	/**
	 * 写博客
	 * @param blogInfo 前台编辑完成的待保存博客内容
	 * @param resp Response
	 * @throws IOException
	 */
	@RequestMapping("/insert")
	public void insertBlog(BlogInfoEntity blogInfo, HttpServletResponse resp) throws IOException {
		LOGGER.debug("insert: blogInfo:{} ", blogInfo);
		int resultTotal = 0;
		if (blogInfo.getId() == null) {
			resultTotal = blogInfoService.insertBlog(blogInfo);
		} else {
			resultTotal = blogInfoService.updateBlogInfo(blogInfo);
		}
		JSONObject result = new JSONObject();
		if (resultTotal > 0) {
			result.put("success", true);
		} else {
			result.put("success", false);
		}
		ResponseUtil.write(resp, result);
	}

	/**
	 * 博客一览页面查询功能 
	 * @param page 查询的页码
	 * @param rows 查询的条数
	 * @param blog 搜索的博客(Title) 
	 * @param resp Response
	 * @throws IOException
	 */
	@RequestMapping("/querypageBlogs")
	public void querypageBlogs(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows, BlogInfoEntity blog, HttpServletResponse resp)
			throws IOException {
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

	/**
	 * @param ids 要删除的所有博客的id
	 * @param resp Response
	 * @throws IOException
	 */
	@RequestMapping("/deleteBlog")
	public void deleteBlogInfos(@RequestParam(value = "ids") String ids, HttpServletResponse resp) throws IOException {
		Arrays.stream(ids.split(",")).forEach(x -> blogInfoService.deleteBlogInfoById(Integer.parseInt(x)));
		JSONObject json = new JSONObject();
		json.put("success", true);
		ResponseUtil.write(resp, json);
	}

	@RequestMapping("queryBlogInfoById")
	public void queryBlogInfoById(@RequestParam(value="id") String id, HttpServletResponse resp) throws IOException {
		JSONObject json = new JSONObject();
		json.put("success", true);
		json.put("entity", blogInfoService.queryBlogInfoById(Integer.valueOf(id)));
		ResponseUtil.write(resp, json);
	}
}
