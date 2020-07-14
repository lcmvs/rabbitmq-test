package com.lcm.test.rabbitproducer.publish;

import com.lcm.test.rabbitproducer.pojo.WorkMsg;
import com.lcm.test.rabbitproducer.property.QueueProperty;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: lcm
 * @create: 2020-07-01 13:46
 **/
@Component
public class FanoutListener {

    @RabbitListener(queues = QueueProperty.PUBSUB_QUEUE_1)
    public void pubsubProcess1(WorkMsg msg){
        System.out.println(msg);
    }

    @RabbitListener(queues = QueueProperty.PUBSUB_QUEUE_1)
    public void pubsubProcess11(WorkMsg msg){
        System.out.println(msg);
    }

    @RabbitListener(queues = QueueProperty.PUBSUB_QUEUE_2)
    public void pubsubProcess2(WorkMsg msg){
        System.out.println(msg);
    }

    @RabbitListener(queues = QueueProperty.PUBSUB_QUEUE_3)
    public void pubsubProcess3(WorkMsg msg){
        System.out.println(msg);
    }
}
