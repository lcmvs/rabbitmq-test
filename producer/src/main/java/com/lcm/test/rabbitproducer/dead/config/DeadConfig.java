package com.lcm.test.rabbitproducer.dead.config;

import com.lcm.test.rabbitproducer.property.QueueProperty;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: lcm
 * @create: 2020-06-30 15:12
 **/
@Configuration
public class DeadConfig {

    /**
     * 声明work死信队列
     * @return
     */
    @Bean
    public Queue deadWorkQueue() {
        return QueueBuilder.durable(QueueProperty.DEAD_WORK_QUEUE).build();
    }

    /**
     * 声明死信队列交换机
     * @return
     */
    @Bean
    public DirectExchange deadLetterExchange() {
        return ExchangeBuilder.directExchange(QueueProperty.DEAD_EXCHANGE).durable(true).build();
    }

    /**
     * 死信队列绑定交换机
     * @return
     */
    @Bean
    public Binding deadLetterBinding(Queue deadWorkQueue, DirectExchange deadLetterExchange) {
        return BindingBuilder
                .bind(deadWorkQueue)
                .to(deadLetterExchange)
                .with(QueueProperty.DEAD_WORK_QUEUE);
    }

}
