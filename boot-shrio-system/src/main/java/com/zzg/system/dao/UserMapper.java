package com.zzg.system.dao;

import java.util.List;

import com.common.dao.MyMapper;
import com.zzg.system.domain.User;
import com.zzg.system.domain.UserWithRole;

public interface UserMapper extends MyMapper<User> {

	List<User> findUserWithDept(User user);
	
	List<UserWithRole> findUserWithRole(Long userId);
	
	User findUserProfile(User user);
}