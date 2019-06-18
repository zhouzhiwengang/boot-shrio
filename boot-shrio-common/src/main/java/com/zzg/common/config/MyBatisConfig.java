package com.zzg.common.config;

import java.util.Properties;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zzg.common.interceptor.SqlStatementInterceptor;

import tk.mybatis.spring.mapper.MapperScannerConfigurer;

/**
 * 
 * @ClassName:  MyBatisConfig   
 * @Description: MyBatis 配置属性  
 * @author: 世纪伟图 -zzg
 * @date:   2019年6月14日 下午2:28:11   
 *     
 * @Copyright: 2019 www.digipower.cn 
 * 注意：本内容仅限于深圳市世纪伟图科技开发有限公司内部使用，禁止用于其他的商业目的
 */
@Configuration
public class MyBatisConfig {
	
	 /**
     * 配置 sql打印拦截器
     * application.yml中 febs.showsql: true 时生效
     *
     * @return SqlStatementInterceptor
     */
    @Bean
    @ConditionalOnProperty(name = "febs.showsql", havingValue = "true")
    SqlStatementInterceptor sqlStatementInterceptor() {
        return new SqlStatementInterceptor();
    }

}
