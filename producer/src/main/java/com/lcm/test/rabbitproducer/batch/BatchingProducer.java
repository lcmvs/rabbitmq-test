package com.lcm.test.rabbitproducer.batch;

import com.lcm.test.rabbitproducer.pojo.WorkMsg;
import com.lcm.test.rabbitproducer.property.QueueProperty;
import org.springframework.amqp.rabbit.core.BatchingRabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @description:
 * @author: lcm
 * @create: 2020-07-13 17:44
 **/
@Component
public class BatchingProducer {

    @Autowired
    BatchingRabbitTemplate batchingRabbitTemplate;

    public void send(WorkMsg msg){
        batchingRabbitTemplate.convertAndSend(QueueProperty.BATCH_QUEUE, msg);
    }

}
