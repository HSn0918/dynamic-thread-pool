package com.hsn0918.middleware.dynamic.thread.pool.sdk.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 动态线程池配置属性类，用于从配置文件中读取动态线程池的相关配置信息。
 *
 * <p>通过使用 {@link ConfigurationProperties} 注解，Spring Boot 会自动将配置文件中以
 * "dynamic.thread.pool.config" 开头的属性注入到本类对应的字段中。</p>
 *
 * <p>配置属性包括 Redis 连接的主机地址、端口号、密码、连接池大小、最小空闲连接数、连接超时时间等。</p>
 *
 * <ul>
 *     <li>{@code enable} - 状态；true = 开启、false = 关闭</li>
 *     <li>{@code host} - Redis 主机地址</li>
 *     <li>{@code port} - Redis 端口号</li>
 *     <li>{@code password} - Redis 密码</li>
 *     <li>{@code poolSize} - 连接池的大小，默认为64</li>
 *     <li>{@code minIdleSize} - 连接池的最小空闲连接数，默认为10</li>
 *     <li>{@code idleTimeout} - 连接的最大空闲时间（单位：毫秒），超过该时间的空闲连接将被关闭，默认为10000</li>
 *     <li>{@code connectTimeout} - 连接超时时间（单位：毫秒），默认为10000</li>
 *     <li>{@code retryAttempts} - 连接重试次数，默认为3</li>
 *     <li>{@code retryInterval} - 连接重试的间隔时间（单位：毫秒），默认为1000</li>
 *     <li>{@code pingInterval} - 定期检查连接是否可用的时间间隔（单位：毫秒），默认为0，表示不进行定期检查</li>
 *     <li>{@code keepAlive} - 是否保持长连接，默认为true</li>
 * </ul>
 *
 * @see org.springframework.boot.context.properties.ConfigurationProperties
 * @since 2024/6/4
 */
@ConfigurationProperties(prefix = "dynamic.thread.pool.config", ignoreInvalidFields = true)
public class DynamicThreadPoolAutoProperties {

    private boolean enable;
    private String host;
    private int port;
    private String password;
    private int poolSize = 64;
    private int minIdleSize = 10;
    private int idleTimeout = 10000;
    private int connectTimeout = 10000;
    private int retryAttempts = 3;
    private int retryInterval = 1000;
    private int pingInterval = 0;
    private boolean keepAlive = true;

    // getters and setters

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }

    public int getMinIdleSize() {
        return minIdleSize;
    }

    public void setMinIdleSize(int minIdleSize) {
        this.minIdleSize = minIdleSize;
    }

    public int getIdleTimeout() {
        return idleTimeout;
    }

    public void setIdleTimeout(int idleTimeout) {
        this.idleTimeout = idleTimeout;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getRetryAttempts() {
        return retryAttempts;
    }

    public void setRetryAttempts(int retryAttempts) {
        this.retryAttempts = retryAttempts;
    }

    public int getRetryInterval() {
        return retryInterval;
    }

    public void setRetryInterval(int retryInterval) {
        this.retryInterval = retryInterval;
    }

    public int getPingInterval() {
        return pingInterval;
    }

    public void setPingInterval(int pingInterval) {
        this.pingInterval = pingInterval;
    }

    public boolean isKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(boolean keepAlive) {
        this.keepAlive = keepAlive;
    }
}