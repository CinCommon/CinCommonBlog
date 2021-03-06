package com.yinzifan.service.impl;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.yinzifan.entity.BlogInfoEntity;
import com.yinzifan.entity.BlogTypeEntity;
import com.yinzifan.entity.LinkEntity;
import com.yinzifan.entity.UserInfoEntity;
import com.yinzifan.service.BlogInfoService;
import com.yinzifan.service.BlogTypeService;
import com.yinzifan.service.LinkService;
import com.yinzifan.service.UserInfoService;

/**
* @author Cin
* @time 2018/01/25 22:42:44
*/
@Component("initComponent")
public class InitComponent implements
 ServletContextListener, ApplicationContextAware{
	private static ApplicationContext applicationContext;
	private static final Logger LOGGER = LoggerFactory.getLogger(InitComponent.class);
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	    LOGGER.debug("InitComponent.setApplicationContext(applicationContext)");
		InitComponent.applicationContext = applicationContext;
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
	    LOGGER.debug("InitComponent.contextInitialized(sce)");
		ServletContext servletContext = sce.getServletContext();
		/**
		 * get User info
		 */
		UserInfoService userInfoService = applicationContext.getBean("userInfoService", UserInfoService.class);
		UserInfoEntity userInfo = userInfoService.queryUserInfoDefault();
		userInfo.setPassword(null);
		servletContext.setAttribute("loginUser", userInfo);
		/**
		 * get Link info
		 */
		LinkService linkService = applicationContext.getBean("linkService",LinkService.class);
		List<LinkEntity> links = linkService.query(null);
		LOGGER.debug("getLinkEntities: {}" , links.toString());
		servletContext.setAttribute("links", links );
		/**
		 * get Blog info
		 */
		BlogInfoService blogInfoService = applicationContext.getBean("blogInfoService", BlogInfoService.class);
		List<BlogInfoEntity> blogInfoEntites= blogInfoService.countCate();
		servletContext.setAttribute("blogInfoEntites", blogInfoEntites);
		BlogTypeService blogTypeService = applicationContext.getBean("blogTypeService", BlogTypeService.class);
		List<BlogTypeEntity> blogTypeEntites= blogTypeService.countCate();
		servletContext.setAttribute("blogTypeEntites", blogTypeEntites);
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	    LOGGER.debug("InitComponent.contextDestroyed(sce)");
	}

}
