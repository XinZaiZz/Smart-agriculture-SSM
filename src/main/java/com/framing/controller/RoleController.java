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

import com.framing.pojo.Role;
import com.framing.service.RoleService;
import com.framing.support.DateSupport;

/**
 * 
 * @author czl
 *
 */
@RestController
@RequestMapping(value="/role")
public class RoleController {
	Logger logger = LoggerFactory.getLogger(RoleController.class);
	@Autowired
	RoleService roleService;
	@Autowired
	DateSupport dateSupport;
	
	/**
	 * 查询方法
	 */
	@ResponseBody
	@RequestMapping(value="/find", method = RequestMethod.POST)
	public Role find(Role role){
		logger.debug("getRole begin ====");
		try {
			role.setRows(roleService.getRole(role));
			role.setSuccess(true);
			role.setMessage("查询成功！");
		}catch(Exception e) {
			role.setSuccess(false);
			role.setMessage("查询失败！");
			logger.error("getRole error ",e);
		}
		return role;
	}
	/**
	 * 获取一个对象
	 */
	@ResponseBody
	@RequestMapping(value="/getOne")
	public Role getOne(Role role){
		logger.debug("getOneRole begin param ===>id={}",role.getSid());
		
		try {
			role=roleService.getOneRole(role.getSid());
			role.setSuccess(true);
			role.setMessage("查询成功！");
		}catch(Exception e) {
			role.setSuccess(false);
			role.setMessage("查询失败！");
			logger.error("getOneRole error ",e);
		}
		return role;
	}
	/**
	 * 保存方法
	 */
	@ResponseBody
	@RequestMapping(value="/save")
	public  Role save(Role role){
		try {
			boolean flag=false;
			if(role.getSid()!=null){
				role.setLastUpdatedBy("admin");
				role.setLastUpdated(dateSupport.getSystemDate());
				flag = roleService.updateRole(role);
				role.setSuccess(flag);
				role.setMessage(flag?"修改成功":"修改失败");
			}else {
				role.setCreatedBy("admin");
				role.setCreated(dateSupport.getSystemDate());
				flag = roleService.addRole(role);
				role.setSuccess(flag);
				role.setMessage(flag?"新增成功":"新增失败");
			}
		}catch(Exception e) {
			role.setSuccess(false);
			role.setMessage("保存失败！");
			logger.error("addRole error ",e);
		}
		return role;
	}
	
	/**
	 * 删除方法
	 */
	@ResponseBody
	@RequestMapping(value="/delete")
	public Role delete(@RequestBody ArrayList<Role> userList){
		logger.debug("getRole begin ====");
		Role role = new Role(); 
		try {
			for(Role user:userList){
				roleService.deleteRole(user.getSid());
			}
			role.setSuccess(true);
			role.setMessage("删除成功！");
		}catch(Exception e) {
			role.setSuccess(false);
			role.setMessage("删除失败！");
			logger.error("deleteRole error ",e);
		}
		return role;
	}
}
