package com.zzg.job.util;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ScheduleTask implements Job {
	@Override
	public void execute(JobExecutionContext jobExecutionContext) {
		JobDataMap map = jobExecutionContext.getJobDetail().getJobDataMap();

		System.out.println(map.get("name") + " Hello, I'm the quartz job!");
	}
}
