package com.zzg.job.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.quartz.*;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import java.util.Objects;

import static org.quartz.CronScheduleBuilder.cronSchedule;

import com.zzg.job.service.TaskService;
import com.zzg.job.util.ScheduleTask;

@Service("taskService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class TaskServiceImpl implements TaskService{
	 	@Autowired
	    private SchedulerFactoryBean schedulerFactoryBean;

	    @Override
	    public void addJob(String jobName, String jobGroupName, String triggerName,
	                       String triggerGroupName, Class jobClass, String cron) {
	        Scheduler scheduler = schedulerFactoryBean.getScheduler();
	        JobDataMap jobDataMap = new JobDataMap();
	        jobDataMap.put("name", jobName);
	        JobDetail jobDetail = JobBuilder.newJob(ScheduleTask.class)
	                .setJobData(jobDataMap)
	                .withDescription("quartz")
	                .withIdentity(jobName, jobGroupName)
	                .build();
	        Trigger trigger = TriggerBuilder.newTrigger()
	                .forJob(jobDetail)
	                .withSchedule(cronSchedule(cron))
	                .build();
	        try {
	            if (!scheduler.checkExists(JobKey.jobKey(triggerName, triggerGroupName))) {
	                scheduler.scheduleJob(jobDetail, trigger);
	            }
	        } catch (SchedulerException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void modifyJobTime(String jobName, String jobGroupName, String triggerName, String triggerGroupName, String cron) {
	        Scheduler scheduler = schedulerFactoryBean.getScheduler();
	        //获取triggerKey
	        TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
	        try {
	            CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
	            if (Objects.isNull(cronTrigger)) {
	                return;
	            }
	            String oldCron = cronTrigger.getCronExpression();
	            if (oldCron.equals(cron)) {
	                //触发器
	                TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
	                //触发器名，触发器组
	                triggerBuilder.withIdentity(triggerName, triggerGroupName);
	                triggerBuilder.startNow();
	                //时间设置
	                triggerBuilder.withSchedule(cronSchedule(cron));
	                //创建trigger对象
	                cronTrigger = (CronTrigger) triggerBuilder.build();
	                scheduler.rescheduleJob(triggerKey, cronTrigger);
	            }
	        } catch (SchedulerException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void removeJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName) {
	        Scheduler scheduler = schedulerFactoryBean.getScheduler();
	        //获取triggerKey
	        TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
	        try {
	            //暂停trigger
	            scheduler.pauseTrigger(triggerKey);
	            //停止trigger
	            scheduler.unscheduleJob(triggerKey);
	            //移除trigger
	            scheduler.deleteJob(JobKey.jobKey(jobName, jobGroupName));
	        } catch (SchedulerException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void startJobs() {
	        Scheduler scheduler = schedulerFactoryBean.getScheduler();
	        try {
	            scheduler.start();
	        } catch (SchedulerException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void shutdownJobs() {
	        Scheduler scheduler = schedulerFactoryBean.getScheduler();
	        try {
	            if (!scheduler.isShutdown()) {
	                scheduler.shutdown();
	            }
	        } catch (SchedulerException e) {
	            e.printStackTrace();
	        }
	    }

}
