package com.lcm.test.rabbitproducer.publish;

import com.lcm.test.rabbitproducer.pojo.WorkMsg;
import com.lcm.test.rabbitproducer.property.QueueProperty;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: lcm
 * @create: 2020-07-01 13:46
 **/
@Component
public class FanoutProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send1(WorkMsg msg) {
        rabbitTemplate.convertAndSend(QueueProperty.PUBSUB_EXCHANGE,"1", msg);
    }

    public void send2(WorkMsg msg) {
        rabbitTemplate.convertAndSend(QueueProperty.PUBSUB_EXCHANGE,"2", msg);
    }

    public void send3(WorkMsg msg) {
        rabbitTemplate.convertAndSend(QueueProperty.PUBSUB_EXCHANGE,"", msg);
    }
}
