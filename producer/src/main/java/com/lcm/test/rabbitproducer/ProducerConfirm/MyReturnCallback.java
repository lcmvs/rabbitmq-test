package com.lcm.test.rabbitproducer.ProducerConfirm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: lcm
 * @create: 2020-07-14 11:53
 **/
@Slf4j
@Component
public class MyReturnCallback implements RabbitTemplate.ReturnCallback {

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        log.info("returnedMessage ===> replyCode={} ,replyText={} ,exchange={} ,routingKey={},message={}",
                replyCode, replyText, exchange, routingKey,message);
    }

}