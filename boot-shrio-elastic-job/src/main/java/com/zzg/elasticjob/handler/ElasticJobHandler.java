package com.zzg.elasticjob.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.event.JobEventConfiguration;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.zzg.common.util.SpringContextUtils;
import com.zzg.elasticjob.task.MyElasticJob;

/**
 * 
 * @ClassName: ElasticJobHandler
 * @Description: ElasticJob 处理器
 * @author: 世纪伟图 -zzg
 * @date: 2019年6月19日 上午10:24:48
 * 
 * @Copyright: 2019 www.digipower.cn 注意：本内容仅限于深圳市世纪伟图科技开发有限公司内部使用，禁止用于其他的商业目的
 */
@Component
public class ElasticJobHandler {
	@Autowired
	private ZookeeperRegistryCenter registryCenter;
	@Autowired
	private JobEventConfiguration jobEventConfiguration;
	@Autowired
	private ElasticJobListener elasticJobListener;

	/**
	 * @param jobName
	 * @param jobClass
	 * @param shardingTotalCount
	 * @param cron
	 * @param id
	 *            数据ID
	 * @return
	 */
	private static LiteJobConfiguration.Builder simpleJobConfigBuilder(String jobName,
			Class<? extends SimpleJob> jobClass, int shardingTotalCount, String cron, String id) {
		return LiteJobConfiguration.newBuilder(new SimpleJobConfiguration(
				JobCoreConfiguration.newBuilder(jobName, cron, shardingTotalCount).jobParameter(id).build(),
				jobClass.getCanonicalName()));
	}

	/**
	 * 添加一个定时任务
	 *
	 * @param jobName
	 *            任务名
	 * @param cron
	 *            表达式
	 * @param shardingTotalCount
	 *            分片数
	 */
	public void addJob(String jobName, String beanName, String cron, Integer shardingTotalCount, String id) {
		MyElasticJob job = (MyElasticJob) SpringContextUtils.getBean(beanName);
		
		
		LiteJobConfiguration jobConfig = simpleJobConfigBuilder(jobName, job.getClass(), shardingTotalCount, cron,
				id).overwrite(true).build();

		new SpringJobScheduler(job, registryCenter, jobConfig, jobEventConfiguration, elasticJobListener)
				.init();
	}

}
