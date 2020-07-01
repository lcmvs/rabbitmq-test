package com.lcm.test.rabbitproducer.publish;

import com.lcm.test.rabbitproducer.property.QueueProperty;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: lcm
 * @create: 2020-07-01 13:46
 **/
@Component
public class FanoutConfig {

    /**
     * 声明 pubsub队列
     * @return
     */
    @Bean
    public Queue pubsubQueue1() {
        return QueueBuilder.durable(QueueProperty.PUBSUB_QUEUE_1).build();
    }

    @Bean
    public Queue pubsubQueue2() {
        return QueueBuilder.durable(QueueProperty.PUBSUB_QUEUE_2).build();
    }

    @Bean
    public Queue pubsubQueue3() {
        return QueueBuilder.durable(QueueProperty.PUBSUB_QUEUE_3).build();
    }

    /**
     * 声明队列交换机
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return ExchangeBuilder.fanoutExchange(QueueProperty.PUBSUB_EXCHANGE).durable(true).build();
    }

    /**
     * 队列绑定交换机
     * @return
     */
    @Bean
    public Binding pubsubQueue1Binding(Queue pubsubQueue1, FanoutExchange fanoutExchange) {
        return BindingBuilder
                .bind(pubsubQueue1)
                .to(fanoutExchange);
    }

    @Bean
    public Binding pubsubQueue2Binding(Queue pubsubQueue2, FanoutExchange fanoutExchange) {
        return BindingBuilder
                .bind(pubsubQueue2)
                .to(fanoutExchange);
    }

    @Bean
    public Binding pubsubQueue3Binding(Queue pubsubQueue3, FanoutExchange fanoutExchange) {
        return BindingBuilder
                .bind(pubsubQueue3)
                .to(fanoutExchange);
    }

}
