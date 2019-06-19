package com.zzg.elasticjob.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

@Component("myElasticJob")
public class MyElasticJob implements SimpleJob {
	// 日志记录
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void execute(ShardingContext shardingContext) {
		// TODO Auto-generated method stub
		 //打印出任务相关信息，JobParameter用于传递任务的ID
        log.info("任务名：{}, 片数：{}, id={}", shardingContext.getJobName(), shardingContext.getShardingTotalCount(),
                shardingContext.getJobParameter());
	}

}
