package com.hsn0918.middleware.dynamic.thread.pool.sdk.domain;

import com.hsn0918.middleware.dynamic.thread.pool.sdk.domain.model.entity.ThreadPoolConfigEntity;

import java.util.List;

/**
 * @author HSn
 * @email hsn.zj@foxmail.com
 * @description
 * @create 2024/6/4 23:58
 */
public interface IDynamicThreadPoolService {
    List<ThreadPoolConfigEntity> queryThreadPoolList();

    ThreadPoolConfigEntity queryThreadPoolConfigByName(String threadPoolName);
    void updateThreadPoolConfig(ThreadPoolConfigEntity threadPoolConfigEntity);
}
