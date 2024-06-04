package com.hsn0918.middleware.dynamic.thread.pool.sdk.registry;

import com.hsn0918.middleware.dynamic.thread.pool.sdk.domain.model.entity.ThreadPoolConfigEntity;

import java.util.List;

/**
 * @author HSn
 * @email hsn.zj@foxmail.com
 * @description 注册中心接口
 * @create 2024/6/5 00:35
 */
public interface IRegistry {

    void reportThreadPool(List<ThreadPoolConfigEntity> threadPoolConfigEntityList);
    void reportThreadPoolConfigParameter(ThreadPoolConfigEntity threadPoolConfigEntity);
}
