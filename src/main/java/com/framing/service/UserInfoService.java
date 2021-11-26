package com.framing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framing.mapper.UserInfoMapper;
import com.framing.pojo.UserInfo;

@Service
public class UserInfoService {
	@Autowired
	UserInfoMapper userInfoMapper;
	
	public UserInfo loginIn(UserInfo test){
		return userInfoMapper.loginIn(test);
	}
	
	public List<UserInfo> getUserInfo(UserInfo test){
		return userInfoMapper.getUserInfo(test);
	}
	
	public boolean addUserInfo(UserInfo test) {
		boolean flag = false;
		int result = userInfoMapper.addUserInfo(test);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public boolean updateUserInfo(UserInfo test) {
		boolean flag = false;
		int result = userInfoMapper.updateUserInfo(test);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public boolean deleteUserInfo(Integer id) {
		boolean flag = false;
		int result = userInfoMapper.deleteUserInfo(id);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public UserInfo getOneUserInfo(Integer id) {
		return userInfoMapper.getOneUserInfo(id);
	}

}
