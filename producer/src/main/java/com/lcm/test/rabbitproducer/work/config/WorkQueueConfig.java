package com.lcm.test.rabbitproducer.work.config;

import com.lcm.test.rabbitproducer.property.QueueProperty;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @description:
 * @author: lcm
 * @create: 2020-06-30 10:23
 **/
@Configuration
public class WorkQueueConfig {

    @Bean
    public Queue workQueue() {
        return QueueBuilder
                .durable(QueueProperty.WORK_QUEUE)
                //最大长度
                .withArgument("x-max-length", 10000)
                //过期时间
                .withArgument("x-message-ttl", 60*60*1000)
                .withArgument("x-dead-letter-exchange", QueueProperty.DEAD_EXCHANGE)
                .withArgument("x-dead-letter-routing-key", QueueProperty.DEAD_WORK_QUEUE)
                .build();
    }

}
