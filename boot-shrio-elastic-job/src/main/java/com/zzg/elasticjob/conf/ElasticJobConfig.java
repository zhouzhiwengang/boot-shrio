package com.zzg.elasticjob.conf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dangdang.ddframe.job.event.JobEventConfiguration;
import com.dangdang.ddframe.job.event.rdb.JobEventRdbConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.zzg.elasticjob.listener.ElasticJobListener;

/**
 * 
 * @ClassName:  ElasticJobConfig   
 * @Description: ElasticJob 实例化配置参数
 * @author: 世纪伟图 -zzg
 * @date:   2019年6月19日 上午9:59:11   
 *     
 * @Copyright: 2019 www.digipower.cn 
 * 注意：本内容仅限于深圳市世纪伟图科技开发有限公司内部使用，禁止用于其他的商业目的
 */
@Configuration
public class ElasticJobConfig {
	// zookeeper 服务地址
	@Value("${elasticjob.serverlists}")
	private String serverlists;
	// zookeeper 命名空间
	@Value("${elasticjob.namespace}")
	private String namespace;

	public String getServerlists() {
		return serverlists;
	}

	public void setServerlists(String serverlists) {
		this.serverlists = serverlists;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	// zookeeper 配置参数
	@Bean
	public ZookeeperConfiguration zkConfig() {
		return new ZookeeperConfiguration(serverlists, namespace);
	}

	// zookeeper 注册中心实例化
	@Bean(initMethod = "init")
	public ZookeeperRegistryCenter regCenter(ZookeeperConfiguration config) {
		return new ZookeeperRegistryCenter(config);
	}
	
	 /**
     * 将作业运行的痕迹进行持久化到DB
     *
     * @return
     */
    @Bean
    public JobEventConfiguration jobEventConfiguration(DataSource dataSource) {
        return new JobEventRdbConfiguration(dataSource);
    }

    
    @Bean
    public ElasticJobListener elasticJobListener() {
        return new ElasticJobListener(100, 100);
    }

	
	

}
