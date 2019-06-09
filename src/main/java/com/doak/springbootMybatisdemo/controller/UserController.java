package com.doak.springbootMybatisdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doak.springbootMybatisdemo.entity.User;
import com.doak.springbootMybatisdemo.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/login")
	public String dologin(){
		return "login";
	}
	
	@RequestMapping(value="/dologin")
	public String login(User user, Model model){
		System.out.println("user:" + user);
		User user1 = userService.selectUser(user) ;
		System.out.println(user1);
		if(user1 == null){
			model.addAttribute("msg", "用户名或者密码错误！！");
			return "fail";
		}else {
			model.addAttribute("msg", "登录成功！！！");
			return "success";
		}
		
	}
	
	@RequestMapping(value="/register")
	public String register(User user, Model model) {
		int result = 0;
		result = userService.insertUser(user);
		if(result == 0) {
			model.addAttribute("msg", "用户已存在");
			return "login";
		} else {
			model.addAttribute("msg", user.getUserName()+",创建成功！！！");
			return "login";
		}
	}
	

}
