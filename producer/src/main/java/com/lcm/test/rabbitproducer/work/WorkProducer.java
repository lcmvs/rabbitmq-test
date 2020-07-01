package com.lcm.test.rabbitproducer.work;

import com.lcm.test.rabbitproducer.pojo.WorkMsg;
import com.lcm.test.rabbitproducer.property.QueueProperty;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: lcm
 * @create: 2020-06-30 10:20
 **/
@Component
public class WorkProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(WorkMsg msg) {
        rabbitTemplate.convertAndSend(QueueProperty.WORK_QUEUE, msg);
    }

}
