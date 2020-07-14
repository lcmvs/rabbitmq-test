package com.lcm.test.rabbitproducer.batch.config;

import com.lcm.test.rabbitproducer.property.QueueProperty;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @description:
 * @author: lcm
 * @create: 2020-06-30 10:23
 **/
@Configuration
public class BatchQueueConfig {

    @Bean
    public Queue batchQueue() {
        return QueueBuilder
                .durable(QueueProperty.BATCH_QUEUE)
                .build();
    }

}
