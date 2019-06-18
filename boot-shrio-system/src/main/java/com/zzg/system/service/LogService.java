package com.zzg.system.service;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.scheduling.annotation.Async;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zzg.common.service.IService;
import com.zzg.system.domain.SysLog;

public interface LogService extends IService<SysLog> {
	
	List<SysLog> findAllLogs(SysLog log);
	
	void deleteLogs(String logIds);

	@Async
	void saveLog(ProceedingJoinPoint point, SysLog log) throws JsonProcessingException;
}
