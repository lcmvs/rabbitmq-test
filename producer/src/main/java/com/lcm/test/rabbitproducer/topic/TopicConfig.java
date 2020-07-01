package com.lcm.test.rabbitproducer.topic;

import com.lcm.test.rabbitproducer.property.QueueProperty;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: lcm
 * @create: 2020-07-01 11:51
 **/
@Configuration
public class TopicConfig {

    /**
     * 声明 direct队列
     * @return
     */
    @Bean
    public Queue topicQueue1() {
        return QueueBuilder.durable(QueueProperty.TOPIC_QUEUE_1).build();
    }

    @Bean
    public Queue topicQueue2() {
        return QueueBuilder.durable(QueueProperty.TOPIC_QUEUE_2).build();
    }

    @Bean
    public Queue topicQueue3() {
        return QueueBuilder.durable(QueueProperty.TOPIC_QUEUE_3).build();
    }

    /**
     * 声明队列交换机
     * @return
     */
    @Bean
    public TopicExchange topicExchange() {
        return ExchangeBuilder.topicExchange(QueueProperty.TOPIC_EXCHANGE).durable(true).build();
    }

    /**
     * 队列绑定交换机
     * @return
     */
    @Bean
    public Binding topicQueue1Binding(Queue topicQueue1, TopicExchange topicExchange) {
        return BindingBuilder
                .bind(topicQueue1)
                .to(topicExchange)
                .with("lcm.topic1");
    }

    @Bean
    public Binding topicQueue2Binding(Queue topicQueue2, TopicExchange topicExchange) {
        return BindingBuilder
                .bind(topicQueue2)
                .to(topicExchange)
                .with("lcm.topic2");
    }

    @Bean
    public Binding topicQueue3Binding(Queue topicQueue3, TopicExchange topicExchange) {
        return BindingBuilder
                .bind(topicQueue3)
                .to(topicExchange)
                .with("lcm.*");
    }
}
