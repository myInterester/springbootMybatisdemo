package com.doak.springbootMybatisdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doak.springbootMybatisdemo.entity.User;
import com.doak.springbootMybatisdemo.mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	UserMapper userMapper;
	
	
	public User selectUser(User user){
		return  userMapper.selectUser(user.getUserName(), user.getPassword());
	}
	
	public int insertUser(User user) {
		User exitingUser = userMapper.selectUser(user.getUserName(), user.getPassword());
		if(exitingUser == null) {
			return userMapper.insertUser(user.getUserName(), user.getPassword());
		} else {
			return 0;
		}
	}

	
}
