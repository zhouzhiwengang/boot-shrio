package com.zzg.elasticjob.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zzg.common.service.impl.BaseService;
import com.zzg.elasticjob.dao.JobTaskMapper;
import com.zzg.elasticjob.domain.JobTask;
import com.zzg.elasticjob.handler.ElasticJobHandler;
import com.zzg.elasticjob.service.JobTaskService;


@Service("jobTaskService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class JobTaskServiceImpl extends BaseService<JobTask> implements JobTaskService {
	// 日志记录
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JobTaskMapper jobTaskMapper;
	
	@Autowired
	private ElasticJobHandler jobHandler;

	/**
	 * 
	 * <p>Title: scanAddJob</p>   
	 * <p>Description:扫描db,添加任务 </p>      
	 * @see com.zzg.elasticjob.service.JobTaskService#scanAddJob()
	 */
	@Override
	public void scanAddJob() {
		// TODO Auto-generated method stub
		 List<JobTask> jobTasks = jobTaskMapper.selectAll();
		 jobTasks.forEach(jobTask -> {
//	            Long current = System.currentTimeMillis();
	            String jobName = "job" + jobTask.getSendTime();
	            String beanName = jobTask.getBeanName();
	            String cron = jobTask.getCronExpression();
//	            String cron;
//	            //说明消费未发送，但是已经过了消息的发送时间，调整时间继续执行任务
//	            if (jobTask.getSendTime().getTime() < current) {
//	                //设置为一分钟之后执行，把Date转换为cron表达式
//	                cron = CronUtils.getCron(new Date(current + 60000));
//	            } else {
//	                cron = CronUtils.getCron(new Date(jobTask.getSendTime().getTime()));
//	            }
	            jobHandler.addJob(jobName, beanName, cron, 1, String.valueOf(jobTask.getId()));
	        });
	}

}
