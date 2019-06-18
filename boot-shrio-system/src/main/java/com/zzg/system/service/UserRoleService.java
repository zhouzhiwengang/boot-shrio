package com.zzg.system.service;

import com.zzg.common.service.IService;
import com.zzg.system.domain.UserRole;

public interface UserRoleService extends IService<UserRole> {

	void deleteUserRolesByRoleId(String roleIds);

	void deleteUserRolesByUserId(String userIds);
}
