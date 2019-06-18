package com.zzg.common.config;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 
 * @ClassName: AsyncExecutorPoolConfig
 * @Description: 异步线程池配置对象
 * @author: 世纪伟图 -zzg
 * @date: 2019年6月14日 下午2:44:56
 * 
 * @Copyright: 2019 www.digipower.cn 注意：本内容仅限于深圳市世纪伟图科技开发有限公司内部使用，禁止用于其他的商业目的
 */

@Configuration
public class AsyncExecutorPoolConfig extends AsyncConfigurerSupport {
	@Bean
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

		executor.setCorePoolSize(5);
		executor.setMaxPoolSize(20);
		executor.setQueueCapacity(100);
		executor.setKeepAliveSeconds(30);
		executor.setThreadNamePrefix("asyncTaskExecutor-");

		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		return executor;
	}
}
