package com.zzg;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zzg.config.FebsProperties;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableTransactionManagement // 启动事务
@MapperScan("com.zzg.*.dao") // 扫描dao层
@EnableConfigurationProperties({ FebsProperties.class })
@EnableCaching //启动缓存
@EnableAsync // 启动异步线程池
public class Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).run(args);

	}

}
