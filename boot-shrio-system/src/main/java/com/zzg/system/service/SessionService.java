package com.zzg.system.service;

import java.util.List;

import com.zzg.system.domain.UserOnline;

public interface SessionService {

	List<UserOnline> list();

	boolean forceLogout(String sessionId);
}
