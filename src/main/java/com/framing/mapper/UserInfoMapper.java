package com.framing.mapper;

import java.util.List;

import com.framing.pojo.UserInfo;

public interface UserInfoMapper {
	
	public UserInfo loginIn(UserInfo test);
	public List<UserInfo> getUserInfo(UserInfo test);
	public int addUserInfo(UserInfo test);
	public int updateUserInfo(UserInfo test);
	public int deleteUserInfo(Integer id);
	public UserInfo getOneUserInfo(Integer id);
}
