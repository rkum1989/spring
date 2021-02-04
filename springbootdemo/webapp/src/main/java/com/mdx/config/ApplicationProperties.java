////////////////////////////////////////////////////////////////////////////////////////////
// @ID: ApplicationProperties.java
// @Author: Rituraj Kumar
// Date: 3/19/2018.
//
// Purpose:
// Contains the Application configuration properties
//
// CONFIDENTIAL -- Copyright 2018 MdxDev.
// This is confidential and proprietary information of MdxDev.
// Use of copyright notice is precautionary and does not imply publication or disclosure.
////////////////////////////////////////////////////////////////////////////////////////////
package com.mdx.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * The type Application properties.
 */
@ConfigurationProperties(prefix = ApplicationProperties.CONFIGURATION_PROPERTY_PREFIX,
        ignoreUnknownFields = false)
public class ApplicationProperties {

    /**
     * The Configuration property prefix.
     */
    static final String CONFIGURATION_PROPERTY_PREFIX = "application";
    private final Async async = new Async();

    /**
     * Gets async.
     *
     * @return the async
     */
    public Async getAsync() {
        return async;
    }

    /**
     * The type Async.
     */
    public static class Async {

        private Integer corePoolSize;
        private Integer maxPoolSize;
        private Integer queueCapacity;

        /**
         * Gets core pool size.
         *
         * @return the core pool size
         */
        public Integer getCorePoolSize() {

            return corePoolSize;
        }

        /**
         * Sets core pool size.
         *
         * @param corePoolSize the core pool size
         */
        public void setCorePoolSize(final Integer corePoolSize) {

            this.corePoolSize = corePoolSize;
        }

        /**
         * Gets max pool size.
         *
         * @return the max pool size
         */
        public Integer getMaxPoolSize() {

            return maxPoolSize;
        }

        /**
         * Sets max pool size.
         *
         * @param maxPoolSize the max pool size
         */
        public void setMaxPoolSize(final Integer maxPoolSize) {

            this.maxPoolSize = maxPoolSize;
        }

        /**
         * Gets queue capacity.
         *
         * @return the queue capacity
         */
        public Integer getQueueCapacity() {

            return queueCapacity;
        }

        /**
         * Sets queue capacity.
         *
         * @param queueCapacity the queue capacity
         */
        public void setQueueCapacity(final Integer queueCapacity) {

            this.queueCapacity = queueCapacity;
        }
    }
}
