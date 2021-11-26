package com.framing.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.framing.pojo.UserInfo;
import com.framing.service.UserInfoService;
import com.framing.support.DateSupport;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author czl
 *
 */
@RestController
@RequestMapping(value="/userInfo")
public class UserInfoController {
	Logger logger = LoggerFactory.getLogger(UserInfoController.class);
	@Autowired
	UserInfoService userInfoService;
	@Autowired
	DateSupport dateSupport;
	
	/**
	 * 查询方法
	 */
	@ResponseBody
	@RequestMapping(value="/loginIn", method = RequestMethod.POST)
	public UserInfo loginIn(UserInfo userInfo, HttpServletRequest req){
		logger.debug("getUserInfo begin ====");
		UserInfo user = new UserInfo();
		try {
			user = userInfoService.loginIn(userInfo);
			req.getSession().setAttribute("user",user);
			if(userInfo==null){
				user.setSuccess(false);
				user.setMessage("账号或者密码错误！");
			}else {
				user.setSuccess(true);
				user.setMessage("查询成功！");
			}
		}catch(Exception e) {
			logger.error("getUserInfo error ",e);
		}
		return user;
	}
	/*
	* 用户登出
	* */
	@ResponseBody
	@RequestMapping(value = "/loginout",method = RequestMethod.GET)
	public ModelAndView loginout(ModelAndView modelAndView,HttpServletRequest req){
		HttpSession httpSession = req.getSession();
		httpSession.setAttribute("user",null);
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	/**
	 * 查询方法
	 */
	@ResponseBody
	@RequestMapping(value="/find", method = RequestMethod.POST)
	public UserInfo find(UserInfo userInfo){
		logger.debug("getUserInfo begin ====");
		try {
			userInfo.setRows(userInfoService.getUserInfo(userInfo));
			userInfo.setSuccess(true);
			userInfo.setMessage("查询成功！");
		}catch(Exception e) {
			userInfo.setSuccess(false);
			userInfo.setMessage("查询失败！");
			logger.error("getUserInfo error ",e);
		}
		return userInfo;
	}
	/**
	 * 获取一个对象
	 */
	@ResponseBody
	@RequestMapping(value="/getOne")
	public UserInfo getOne(UserInfo userInfo){
		logger.debug("getOneUserInfo begin param ===>id={}",userInfo.getSid());
		
		try {
			userInfo=userInfoService.getOneUserInfo(userInfo.getSid());
			userInfo.setSuccess(true);
			userInfo.setMessage("查询成功！");
		}catch(Exception e) {
			userInfo.setSuccess(false);
			userInfo.setMessage("查询失败！");
			logger.error("getOneUserInfo error ",e);
		}
		return userInfo;
	}
	/**
	 * 保存方法
	 */
	@ResponseBody
	@RequestMapping(value="/save")
	public  UserInfo save(UserInfo userInfo){
		try {
			boolean flag=false;
			if(userInfo.getSid()!=null){
				userInfo.setLastUpdatedBy("admin");
				userInfo.setLastUpdated(dateSupport.getSystemDate());
				flag = userInfoService.updateUserInfo(userInfo);
				userInfo.setSuccess(flag);
				userInfo.setMessage(flag?"修改成功":"修改失败");
			}else {
				userInfo.setCreatedBy("admin");
				userInfo.setCreated(dateSupport.getSystemDate());
				flag = userInfoService.addUserInfo(userInfo);
				userInfo.setSuccess(flag);
				userInfo.setMessage(flag?"新增成功":"新增失败");
			}
		}catch(Exception e) {
			userInfo.setSuccess(false);
			userInfo.setMessage("保存失败！");
			logger.error("addUserInfo error ",e);
		}
		return userInfo;
	}
	
	/**
	 * 删除方法
	 */
	@ResponseBody
	@RequestMapping(value="/delete")
	public UserInfo delete(@RequestBody ArrayList<UserInfo> userList){
		logger.debug("getUserInfo begin ====");
		UserInfo userInfo = new UserInfo(); 
		try {
			for(UserInfo user:userList){
				userInfoService.deleteUserInfo(user.getSid());
			}
			userInfo.setSuccess(true);
			userInfo.setMessage("删除成功！");
		}catch(Exception e) {
			userInfo.setSuccess(false);
			userInfo.setMessage("删除失败！");
			logger.error("deleteUserInfo error ",e);
		}
		return userInfo;
	}
}
