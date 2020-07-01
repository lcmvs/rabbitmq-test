package com.lcm.test.rabbitproducer.dead;

import com.lcm.test.rabbitproducer.pojo.WorkMsg;
import com.lcm.test.rabbitproducer.property.QueueProperty;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: lcm
 * @create: 2020-06-30 14:59
 **/
@Component
public class DeadListener {

    @RabbitListener(queues = QueueProperty.DEAD_WORK_QUEUE)
    public void workDeadProcess(WorkMsg msg){
        System.out.println(msg);
    }

}
