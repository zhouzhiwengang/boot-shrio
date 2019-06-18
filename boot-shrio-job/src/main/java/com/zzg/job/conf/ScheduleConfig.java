package com.zzg.job.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;


/**
 * 定时任务配置
 * 
 * @author Administrator
 *
 */
@Configuration
public class ScheduleConfig {

	@Bean
	public SchedulerFactoryBean schedulerFactoryBean(DataSource dataSource) {
		SchedulerFactoryBean factory = new SchedulerFactoryBean();
		factory.setDataSource(dataSource);

		// 设置自动启动，默认为true
		factory.setAutoStartup(true);

		return factory;
	}
}
