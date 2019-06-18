package com.zzg.system.dao;

import java.util.List;

import com.common.dao.MyMapper;
import com.zzg.system.domain.Role;
import com.zzg.system.domain.RoleWithMenu;

public interface RoleMapper extends MyMapper<Role> {
	
	List<Role> findUserRole(String userName);
	
	List<RoleWithMenu> findById(Long roleId);
}