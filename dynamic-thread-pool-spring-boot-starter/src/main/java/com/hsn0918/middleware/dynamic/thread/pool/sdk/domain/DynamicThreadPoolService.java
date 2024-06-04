package com.hsn0918.middleware.dynamic.thread.pool.sdk.domain;

import com.alibaba.fastjson.JSON;
import com.hsn0918.middleware.dynamic.thread.pool.sdk.domain.model.entity.ThreadPoolConfigEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;

import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author HSn
 * @email hsn.zj@foxmail.com
 * @description 动态线程池服务
 * @create 2024/6/5 00:05
 */
public class DynamicThreadPoolService implements IDynamicThreadPoolService {


    private final Logger logger = LoggerFactory.getLogger(DynamicThreadPoolService.class);
    private final Map<String, ThreadPoolExecutor> threadPoolExecutorMap;
    private final String applicationName;

    public DynamicThreadPoolService( String applicationName,Map<String, ThreadPoolExecutor> threadPoolExecutorMap) {
        this.applicationName = applicationName;
        this.threadPoolExecutorMap = threadPoolExecutorMap;
    }


    @Override
    public List<ThreadPoolConfigEntity> queryThreadPoolList() {
        Set<String> threadPoolNames = threadPoolExecutorMap.keySet();
        List<ThreadPoolConfigEntity> threadPoolConfigEntityList = new ArrayList<>(threadPoolNames.size());
        for (String threadPoolName : threadPoolNames){
            ThreadPoolExecutor threadPoolExecutor = threadPoolExecutorMap.get(threadPoolName);
            ThreadPoolConfigEntity threadPoolConfigEntity = new ThreadPoolConfigEntity(applicationName, threadPoolName);
            threadPoolConfigEntity.setCorePoolSize(threadPoolExecutor.getCorePoolSize());
            threadPoolConfigEntity.setMaximumPoolSize(threadPoolExecutor.getMaximumPoolSize());
            threadPoolConfigEntity.setActiveCount(threadPoolExecutor.getActiveCount());
            threadPoolConfigEntity.setPoolSize(threadPoolExecutor.getPoolSize());
            threadPoolConfigEntity.setQueueType(threadPoolExecutor.getQueue().getClass().getSimpleName());
            threadPoolConfigEntity.setQueueSize(threadPoolExecutor.getQueue().size());
            threadPoolConfigEntity.setRemainingCapacity(threadPoolExecutor.getQueue().remainingCapacity());
            threadPoolConfigEntityList.add(threadPoolConfigEntity);

        }
        return threadPoolConfigEntityList;
    }

    @Override
    public ThreadPoolConfigEntity queryThreadPoolConfigByName(String threadPoolName) {
        ThreadPoolExecutor threadPoolExecutor = threadPoolExecutorMap.get(threadPoolName);
        if (threadPoolExecutor == null){
            return new ThreadPoolConfigEntity(applicationName, threadPoolName);
        }
        ThreadPoolConfigEntity threadPoolConfigEntity = new ThreadPoolConfigEntity(applicationName, threadPoolName);
        threadPoolConfigEntity.setCorePoolSize(threadPoolExecutor.getCorePoolSize());
        threadPoolConfigEntity.setMaximumPoolSize(threadPoolExecutor.getMaximumPoolSize());
        threadPoolConfigEntity.setActiveCount(threadPoolExecutor.getActiveCount());
        threadPoolConfigEntity.setPoolSize(threadPoolExecutor.getPoolSize());
        threadPoolConfigEntity.setQueueType(threadPoolExecutor.getQueue().getClass().getSimpleName());
        threadPoolConfigEntity.setQueueSize(threadPoolExecutor.getQueue().size());
        threadPoolConfigEntity.setRemainingCapacity(threadPoolExecutor.getQueue().remainingCapacity());
        if(logger.isDebugEnabled()){
            logger.info("queryThreadPoolConfigByName:{}", JSON.toJSONString(threadPoolConfigEntity));
        }

        return threadPoolConfigEntity;

    }

    @Override
    public void updateThreadPoolConfig(ThreadPoolConfigEntity threadPoolConfigEntity) {
        if(null == threadPoolConfigEntity || !applicationName.equals(threadPoolConfigEntity.getAppName())){
            return;
        }
        ThreadPoolExecutor threadPoolExecutor = threadPoolExecutorMap.get(threadPoolConfigEntity.getThreadPoolName());
        if(null == threadPoolExecutor){
            return ;
        }
        threadPoolExecutor.setCorePoolSize(threadPoolConfigEntity.getCorePoolSize());
        threadPoolExecutor.setMaximumPoolSize(threadPoolConfigEntity.getMaximumPoolSize());
    }
}
