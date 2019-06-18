package com.zzg.config;

import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @ClassName:  WebConfig   
 * @Description: web 配置对象
 * @author: 世纪伟图 -zzg
 * @date:   2019年6月14日 下午2:46:53   
 *     
 * @Copyright: 2019 www.digipower.cn 
 * 注意：本内容仅限于深圳市世纪伟图科技开发有限公司内部使用，禁止用于其他的商业目的
 */
@Configuration
public class WebConfig {
	// xss 拦截器
	
	// String 日期格式转换
	@Bean
    public ObjectMapper getObjectMapper(FebsProperties febsProperties) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat(febsProperties.getTimeFormat()));
        return mapper;
    }
}
