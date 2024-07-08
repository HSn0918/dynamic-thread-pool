# dynamic-thread-pool

### Overview

This project demonstrates how to implement a dynamic thread pool using Redis. By storing the thread pool configuration in Redis, it allows dynamic adjustment of parameters such as core thread count and maximum thread count at runtime. This project is based on Spring Boot and aims to provide an easy-to-extend and use dynamic thread pool solution. Additionally, a simple front-end interface is provided to interact with the thread pool configuration.

### Configuration

```yaml
dynamic:
  thread:
    pool:
      config:
        enabled: true
        host: 127.0.0.1
        port: 6379

```

