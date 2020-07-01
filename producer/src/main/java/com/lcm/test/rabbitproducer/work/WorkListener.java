package com.lcm.test.rabbitproducer.work;

import com.lcm.test.rabbitproducer.pojo.WorkMsg;
import com.lcm.test.rabbitproducer.property.QueueProperty;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: lcm
 * @create: 2020-06-30 13:49
 **/
@Component
public class WorkListener {

    @RabbitListener(queues = QueueProperty.WORK_QUEUE)
    public void workProcess(WorkMsg msg){
        System.out.println(msg);
        throw new RuntimeException("抛出异常，死信队列测试");
    }

}
