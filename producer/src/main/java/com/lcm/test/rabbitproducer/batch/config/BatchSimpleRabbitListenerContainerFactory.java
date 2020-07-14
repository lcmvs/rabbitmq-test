package com.lcm.test.rabbitproducer.batch.config;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: lcm
 * @create: 2020-07-13 17:48
 **/
@Configuration
public class BatchSimpleRabbitListenerContainerFactory {

    @Bean(name = "myBatchSimpleRabbitListenerContainerFactory")
    public SimpleRabbitListenerContainerFactory consumerBatchContainerFactory(
            SimpleRabbitListenerContainerFactoryConfigurer configurer, ConnectionFactory connectionFactory) {
        // 创建 SimpleRabbitListenerContainerFactory 对象
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        // 额外添加批量消费的属性
        factory.setBatchListener(true);
        factory.setBatchSize(10);
        factory.setReceiveTimeout(1000L);
        factory.setConsumerBatchEnabled(true);
        return factory;
    }

}
