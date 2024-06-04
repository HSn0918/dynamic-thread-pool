package com.hsn0918.middleware.dynamic.thread.pool.sdk.config;

import com.hsn0918.middleware.dynamic.thread.pool.sdk.domain.DynamicThreadPoolService;
import jodd.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author HSn
 * @email hsn.zj@foxmail.com
 * @description 动态配置入口
 * @create 2024/6/4 23:11
 */
@Configuration
public class DynamicThreadPoolAutoConfig {
    private final Logger logger = LoggerFactory.getLogger(DynamicThreadPoolAutoConfig.class);
    @Bean("dynamicThreadPoolPollService")
    public DynamicThreadPoolService dynamicThreadPoolPollService(ApplicationContext applicationContext, Map<String, ThreadPoolExecutor> threadPoolExecutorMap){
        String applicationName = applicationContext.getEnvironment().getProperty("spring.application.name");
        if (StringUtil.isBlank(applicationName)){
            applicationName = "default";
            logger.warn("spring.application.name is not set, use default value: {}", applicationName);
        }
        return new DynamicThreadPoolService(applicationName, threadPoolExecutorMap);
    }
}
