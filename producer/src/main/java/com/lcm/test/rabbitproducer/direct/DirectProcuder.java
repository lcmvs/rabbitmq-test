package com.lcm.test.rabbitproducer.direct;

import com.lcm.test.rabbitproducer.pojo.WorkMsg;
import com.lcm.test.rabbitproducer.property.QueueProperty;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: lcm
 * @create: 2020-06-30 15:24
 **/
@Component
public class DirectProcuder {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(WorkMsg msg) {
        rabbitTemplate.convertAndSend(QueueProperty.DIRECT_QUEUE_1, msg);
    }

    public void send1(WorkMsg msg) {
        rabbitTemplate.convertAndSend(QueueProperty.DIRECT_EXCHANGE,"1", msg);
    }

    public void send2(WorkMsg msg) {
        rabbitTemplate.convertAndSend(QueueProperty.DIRECT_EXCHANGE,"2", msg);
    }

}
