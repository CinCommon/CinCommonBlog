package com.yinzifan.controller;
/**
* @author Cin
* @time 2018年1月22日 下午10:01:49
* 用户Controller
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yinzifan.service.UserService;
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
}
