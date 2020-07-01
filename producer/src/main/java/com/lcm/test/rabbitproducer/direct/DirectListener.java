package com.lcm.test.rabbitproducer.direct;

import com.lcm.test.rabbitproducer.pojo.WorkMsg;
import com.lcm.test.rabbitproducer.property.QueueProperty;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: lcm
 * @create: 2020-06-30 15:24
 **/
@Component
public class DirectListener {

    @RabbitListener(queues = QueueProperty.DIRECT_QUEUE_1)
    public void directProcess1(WorkMsg msg){
        System.out.println(msg);
    }

    @RabbitListener(queues = QueueProperty.DIRECT_QUEUE_2)
    public void directProcess2(WorkMsg msg){
        System.out.println(msg);
    }

}
