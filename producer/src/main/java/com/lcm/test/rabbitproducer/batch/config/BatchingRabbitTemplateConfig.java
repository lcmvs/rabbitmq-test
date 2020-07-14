package com.lcm.test.rabbitproducer.batch.config;

import org.springframework.amqp.rabbit.batch.BatchingStrategy;
import org.springframework.amqp.rabbit.batch.SimpleBatchingStrategy;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.BatchingRabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

/**
 * @description:
 * @author: lcm
 * @create: 2020-07-13 17:38
 **/
@Configuration
public class BatchingRabbitTemplateConfig {

    @Autowired
    MessageConverter messageConverter;

    @Bean
    public BatchingRabbitTemplate batchRabbitTemplate(ConnectionFactory connectionFactory) {
        // 超过收集的消息数量的最大条数。
        int batchSize = 64;
        // 每次批量发送消息的最大内存,字节
        int bufferLimit = 1024;
        // 超过收集的时间的最大等待时长，单位：毫秒
        int timeout = 1000;
        // 创建 BatchingStrategy 对象，代表批量策略
        BatchingStrategy batchingStrategy = new SimpleBatchingStrategy(batchSize, bufferLimit, timeout);

        // 创建 TaskScheduler 对象，用于实现超时发送的定时器
        TaskScheduler taskScheduler = new ConcurrentTaskScheduler();

        // 创建 BatchingRabbitTemplate 对象
        BatchingRabbitTemplate batchingRabbitTemplate = new BatchingRabbitTemplate(connectionFactory, batchingStrategy, taskScheduler);

        batchingRabbitTemplate.setMessageConverter(messageConverter);

        return batchingRabbitTemplate;
    }

}
