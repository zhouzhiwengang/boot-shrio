package com.zzg.elasticjob.service;

import com.zzg.common.service.IService;
import com.zzg.elasticjob.domain.JobTask;

public interface JobTaskService extends IService<JobTask> {
	/**
	 * 
	 * @Title: scanAddJob   
	 * @Description: 扫描db，并添加任务   
	 * @param:       
	 * @return: void      
	 * @throws
	 */
	 public void scanAddJob();
}
