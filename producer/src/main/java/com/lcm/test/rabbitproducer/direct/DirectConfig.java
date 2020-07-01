package com.lcm.test.rabbitproducer.direct;

import com.lcm.test.rabbitproducer.property.QueueProperty;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: lcm
 * @create: 2020-06-30 15:23
 **/
@Configuration
public class DirectConfig {

    /**
     * 声明 direct队列
     * @return
     */
    @Bean
    public Queue directQueue1() {
        return QueueBuilder.durable(QueueProperty.DIRECT_QUEUE_1).build();
    }

    @Bean
    public Queue directQueue2() {
        return QueueBuilder.durable(QueueProperty.DIRECT_QUEUE_2).build();
    }

    /**
     * 声明队列交换机
     * @return
     */
    @Bean
    public DirectExchange directExchange() {
        return ExchangeBuilder.directExchange(QueueProperty.DIRECT_EXCHANGE).durable(true).build();
    }

    /**
     * 队列绑定交换机
     * @return
     */
    @Bean
    public Binding directQueue1Binding(Queue directQueue1, DirectExchange directExchange) {
        return BindingBuilder
                .bind(directQueue1)
                .to(directExchange)
                .with("1");
    }

    @Bean
    public Binding directQueue2Binding(Queue directQueue2, DirectExchange directExchange) {
        return BindingBuilder
                .bind(directQueue2)
                .to(directExchange)
                .with("2");
    }

}
