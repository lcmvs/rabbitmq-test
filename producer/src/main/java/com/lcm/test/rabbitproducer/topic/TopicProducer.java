package com.lcm.test.rabbitproducer.topic;

import com.lcm.test.rabbitproducer.pojo.WorkMsg;
import com.lcm.test.rabbitproducer.property.QueueProperty;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: lcm
 * @create: 2020-07-01 11:52
 **/
@Component
public class TopicProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(WorkMsg msg) {
        rabbitTemplate.convertAndSend(QueueProperty.TOPIC_QUEUE_1, msg);
    }

    public void send1(WorkMsg msg) {
        rabbitTemplate.convertAndSend(QueueProperty.TOPIC_EXCHANGE,"lcm.topic1", msg);
    }

    public void send2(WorkMsg msg) {
        rabbitTemplate.convertAndSend(QueueProperty.TOPIC_EXCHANGE,"lcm.topic2", msg);
    }


}
