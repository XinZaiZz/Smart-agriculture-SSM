package com.framing.mapper;

import java.util.List;

import com.framing.pojo.Role;

public interface RoleMapper {
	
	public List<Role> getRole(Role test);
	public int addRole(Role test);
	public int updateRole(Role test);
	public int deleteRole(Integer id);
	public Role getOneRole(Integer id);
}
