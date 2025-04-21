# Dynamic Thread Pool

## 概述

Dynamic Thread Pool 是一个基于 Spring Boot 和 Redis 实现的动态线程池管理系统。该项目允许在运行时动态调整线程池的各项参数，如核心线程数、最大线程数等，并提供了直观的前端界面进行配置管理。

## 特性

- 🚀 基于 Redis 的动态配置管理
- 💻 实时调整线程池参数
- 📊 可视化监控界面
- 🔧 简单易用的配置接口
- 🎯 高性能和可扩展性
- 🛡️ 线程池参数动态校验

## 快速开始

### 前置条件

- JDK 8+
- Redis 6.0+
- Maven 3.6+

### 安装步骤

1. 克隆项目
```bash
git clone https://github.com/hsn0918/dynamic-thread-pool.git
cd dynamic-thread-pool
```

2. 配置 Redis 连接
在 `application.yml` 中配置 Redis 连接信息：

```yaml
dynamic:
  thread:
    pool:
      config:
        enabled: true
        host: 127.0.0.1
        port: 6379
```

3. 启动项目
```bash
mvn spring-boot:run
```

## 使用说明

### 线程池配置

可以通过以下方式配置线程池参数：

1. 通过前端界面配置（访问 `http://localhost:8080`）
2. 通过 REST API 接口配置
3. 通过 Redis 直接设置

### 核心参数说明

- `corePoolSize`: 核心线程数
- `maximumPoolSize`: 最大线程数
- `keepAliveTime`: 线程空闲超时时间
- `queueCapacity`: 任务队列容量
## 监控指标

系统提供以下监控指标：

- 活跃线程数
- 队列深度
- 任务完成率
- 线程池使用率

## 贡献指南

欢迎提交 Pull Request 或提出 Issue。
