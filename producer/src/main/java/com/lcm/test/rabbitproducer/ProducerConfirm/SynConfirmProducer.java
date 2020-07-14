package com.lcm.test.rabbitproducer.ProducerConfirm;

import com.lcm.test.rabbitproducer.pojo.WorkMsg;
import com.rabbitmq.client.ConfirmCallback;
import org.springframework.amqp.rabbit.core.RabbitOperations;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @description:
 * @author: lcm
 * @create: 2020-07-14 11:32
 **/
@Component
public class SynConfirmProducer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void synProducer(WorkMsg msg){
        rabbitTemplate.invoke(operations -> {
            // 同步发送消息
            operations.convertAndSend("error", "error", "test");
            // 等待确认 timeout 参数，如果传递 0 ，表示无限等待
            operations.waitForConfirms(0);
            return null;
        }, (deliveryTag, multiple) -> {
        }, (deliveryTag, multiple) -> {
            throw new RuntimeException("同步发送失败！");
        });
    }

}
