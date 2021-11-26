package com.framing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framing.mapper.RoleMapper;
import com.framing.pojo.Role;

@Service
public class RoleService {
	@Autowired
	RoleMapper roleMapper;
	
	public List<Role> getRole(Role test){
		return roleMapper.getRole(test);
	}
	
	public boolean addRole(Role test) {
		boolean flag = false;
		int result = roleMapper.addRole(test);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public boolean updateRole(Role test) {
		boolean flag = false;
		int result = roleMapper.updateRole(test);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public boolean deleteRole(Integer id) {
		boolean flag = false;
		int result = roleMapper.deleteRole(id);
		if(result==1){
			flag = true;
		}
		return flag;
	}
	
	public Role getOneRole(Integer id) {
		return roleMapper.getOneRole(id);
	}

}
