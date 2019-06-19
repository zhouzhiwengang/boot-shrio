package com.zzg.elasticjob.listener;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.AbstractDistributeOnceElasticJobListener;

/**
 * 
 * @ClassName:  ElasticJobListener   
 * @Description: 实现分布式任务监听器, 如果任务有分片，分布式监听器会在总的任务开始前执行一次，结束时执行一次   
 * @author: 世纪伟图 -zzg
 * @date:   2019年6月19日 上午10:02:23   
 *     
 * @Copyright: 2019 www.digipower.cn 
 * 注意：本内容仅限于深圳市世纪伟图科技开发有限公司内部使用，禁止用于其他的商业目的
 */
public class ElasticJobListener extends AbstractDistributeOnceElasticJobListener {

	public ElasticJobListener(long startedTimeoutMilliseconds, long completedTimeoutMilliseconds) {
		super(startedTimeoutMilliseconds, completedTimeoutMilliseconds);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAfterJobExecutedAtLastCompleted(ShardingContexts arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doBeforeJobExecutedAtLastStarted(ShardingContexts arg0) {
		// TODO Auto-generated method stub

	}

}
