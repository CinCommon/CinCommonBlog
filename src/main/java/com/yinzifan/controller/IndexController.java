package com.yinzifan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yinzifan.entity.BlogInfoEntity;
import com.yinzifan.entity.PageBean;
import com.yinzifan.service.BlogInfoService;
import com.yinzifan.service.BlogTypeService;
import com.yinzifan.util.PageUtil;
import com.yinzifan.util.StringUtil;

/**
* @author Cin
* @time 2018/01/27 10:25:40
*/
@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private BlogInfoService blogInfoService;
	@Autowired
	private BlogTypeService blogTypeService;
	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest req, @RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "typeId", required = false) String typeId,
			@RequestParam(value = "formatDate", required = false) String formatDate) {
		LOGGER.info("get data from index.html : page={}, typeId={}, formatDate={}", page, typeId, formatDate);
		ModelAndView mav = new ModelAndView();
		if (StringUtil.isEmpty(page)) {
			page = "1";
		}
		PageBean pageBean = new PageBean(Integer.parseInt(page), 10);
		Map<String, Object> map = new HashMap<String, Object>();
		// 分页查询数据
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		map.put("typeId", typeId);
		map.put("formatDate", formatDate);
		List<BlogInfoEntity> blogList = blogInfoService.queryPageBlog(map);
		blogList.forEach(x -> {
			Document document = Jsoup.parse(x.getContent());
			Elements elements = document.select("img[src$=.jpg]");
			elements.stream().limit(3).forEach(y -> x.getImages().add(y.toString()));
		});
		mav.addObject("pageTitle", "主页");
		StringBuffer sb = new StringBuffer();
		if (StringUtil.isNotEmpty(formatDate)) {
			sb.append("formatDate=" + formatDate + "&");
			mav.addObject("pageTitle", "Cate By " + formatDate);
		}
		if (StringUtil.isNotEmpty(typeId)) {
			sb.append("typeId=" + typeId + "&");
			mav.addObject("pageTitle",
					"Cate By " + blogTypeService.queryBlogTypeById(Integer.valueOf(typeId)).getTypeName());
		}
		String pageHtml = PageUtil.genPagination(req.getContextPath() + "/index.html",
				blogInfoService.queryPageTotal(map), pageBean.getPage(), pageBean.getPageSize(), sb.toString());
		mav.addObject("pageHtml", pageHtml);
		mav.addObject("blogList", blogList);
		// mav.addObject("pageTitle", "java开源博客系统");
		mav.addObject("mainPage", "foreground/blog/list.jsp");
		mav.setViewName("mainTemplate");
		return mav;
	}

	@RequestMapping("navbar_content/about")
	public ModelAndView about(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageTitle", "关于本站");
		mav.addObject("mainPage", "foreground/navbar_content/about.jsp");
		mav.setViewName("mainTemplate");
		return mav;
	}
}
