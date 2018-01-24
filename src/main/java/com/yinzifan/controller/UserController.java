package com.yinzifan.controller;
/**
* @author Cin
* @time 2018年1月22日 下午10:01:49
* 用户Controller
*/

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yinzifan.entity.UserInfoEntity;
import com.yinzifan.service.UserInfoService;
import com.yinzifan.util.Constant;
import com.yinzifan.util.CryptographyUtil;
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserInfoService userService;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping("/login")
	public String login(UserInfoEntity userInfo, HttpServletRequest req) {
		LOGGER.info("login: userInfo : {}", userInfo);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUserName(), CryptographyUtil.md5(userInfo.getPassword(), Constant.MD5_SALT));
		try {
			subject.login(token);
			return "redirect:/admin/main.jsp";
		} catch (AuthenticationException e) {
			e.printStackTrace();
			req.setAttribute("userInfo", userInfo);
			req.setAttribute("errorInfo", "用户名或密码错误, 请核实");
			return "login";
		}
	}
	
}
