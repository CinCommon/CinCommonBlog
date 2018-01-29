package com.yinzifan.controller.admin;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.yinzifan.entity.BlogInfoEntity;
import com.yinzifan.service.BlogInfoService;
import com.yinzifan.util.ResponseUtil;

/**
* @author Cin
* @time 2018/01/28 14:50:44
*/
@Controller
@RequestMapping("/admin/blog")
public class BlogAdminController {
	@Autowired
	private BlogInfoService blogInfoService;

	@RequestMapping("/insert")
	public String insertBlog(HttpServletRequest req, BlogInfoEntity blogInfo, HttpServletResponse resp) throws IOException {
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
		return null;
	}
}
