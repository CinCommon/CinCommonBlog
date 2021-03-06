package com.yinzifan.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yinzifan.entity.BlogInfoEntity;
import com.yinzifan.entity.BlogTypeEntity;
import com.yinzifan.entity.UserInfoEntity;
import com.yinzifan.service.BlogInfoService;

/**
* @author Cin
* @time 2018/01/27 23:37:35
*/
@Controller
@RequestMapping("/")
public class BlogController {
	private final static Logger LOGGER = LoggerFactory.getLogger(BlogController.class);
	@Autowired
	private BlogInfoService blogInfoService;

	@RequestMapping("articles/{id}")
	public ModelAndView loadingBlog(HttpServletRequest req, @PathVariable("id") String id) {
		ModelAndView mav = new ModelAndView();
		LOGGER.info("BlogController.loadingBlog(): id= {}", id);
		BlogInfoEntity entity = blogInfoService.queryBlogInfoById(Integer.valueOf(id));
		Integer clickCount = entity.getClickCount();
		mav.addObject("blogDetails", entity);
		mav.addObject("nextBlogInfo", blogInfoService.queryNextBlogInfo(Integer.valueOf(id)));
		mav.addObject("lastBlogInfo", blogInfoService.queryLastBlogInfo(Integer.valueOf(id)));
		mav.addObject("pageTitle", entity.getTitle());// foreground/blog/blog_content
		mav.addObject("mainPage", "foreground/blog/blog_content.jsp");// foreground/blog/blog_content
		mav.setViewName("mainTemplate");
		if(entity != null) {
			entity = new BlogInfoEntity();
			entity.setId(new Integer(id));
			entity.setBlogType(new BlogTypeEntity());
			entity.setUserInfo(new UserInfoEntity());
			entity.setClickCount(clickCount+1);
			blogInfoService.updateBlogInfo(entity);
		}
		return mav;
	}
}
