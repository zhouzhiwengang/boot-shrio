package com.zzg.common.runner;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

/**
 * 
 * @ClassName:  ApplicationStartupRunner   
 * @Description: 应用启动检测功能  
 * @author: 世纪伟图 -zzg
 * @date:   2019年6月14日 下午3:16:12   
 *     
 * @Copyright: 2019 www.digipower.cn 
 * 注意：本内容仅限于深圳市世纪伟图科技开发有限公司内部使用，禁止用于其他的商业目的
 */
@Component
public class ApplicationStartupRunner implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ConfigurableApplicationContext context;

    @Value("${server.port:8080}")
    private String port;

    @Value("${server.servlet.context-path:}")
    private String contextPath;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (context.isActive()) {
            InetAddress address = InetAddress.getLocalHost();
            String url = String.format("http://%s:%s", address.getHostAddress(), port);
            if (StringUtils.isNotBlank(contextPath))
                url += contextPath;
            logger.info("系统检测完毕，地址：{}", url);
        }
    }
}
