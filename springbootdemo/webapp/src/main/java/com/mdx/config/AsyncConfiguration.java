////////////////////////////////////////////////////////////////////////////////////////////
// @ID: AsyncConfiguration.java
// @Author: Rituraj Kumar
// Date: 3/19/2018.
//
// Purpose:
// Contains the Async configuration details
//
// CONFIDENTIAL -- Copyright 2018 MdxDev.
// This is confidential and proprietary information of MdxDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
////////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * The type Async configuration.
 */
@Configuration
public class AsyncConfiguration implements AsyncConfigurer {

    private static final String TASK_EXECUTOR_NAME_PREFIX_SERVICE = "serviceTaskExecutor-";

    /**
     * The constant TASK_EXECUTOR_SERVICE.
     */
    public static final String TASK_EXECUTOR_SERVICE = "serviceTaskExecutor";

    private final ApplicationProperties applicationProperties;

    /**
     * Instantiates a new Async configuration.
     *
     * @param applicationProperties the application properties
     */
    public AsyncConfiguration(final ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    /**
     * Gets service async executor.
     *
     * @return the service async executor
     */
    @Bean(name = TASK_EXECUTOR_SERVICE)
    public Executor getAsyncExecutor() {

        return newTaskExecutor(TASK_EXECUTOR_NAME_PREFIX_SERVICE);
    }


    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SimpleAsyncUncaughtExceptionHandler();
    }

    private Executor newTaskExecutor(final String taskExecutorNamePrefix) {
        final ApplicationProperties.Async asyncProperties = applicationProperties.getAsync();
        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(asyncProperties.getCorePoolSize());
        executor.setMaxPoolSize(asyncProperties.getMaxPoolSize());
        executor.setQueueCapacity(asyncProperties.getQueueCapacity());
        executor.setThreadNamePrefix(taskExecutorNamePrefix);
        return executor;
    }
}
