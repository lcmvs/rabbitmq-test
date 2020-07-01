package com.lcm.test.rabbitproducer.topic;

import com.lcm.test.rabbitproducer.pojo.WorkMsg;
import com.lcm.test.rabbitproducer.property.QueueProperty;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: lcm
 * @create: 2020-07-01 11:51
 **/
@Component
public class TopicListener {

    @RabbitListener(queues = QueueProperty.TOPIC_QUEUE_1)
    public void topicProcess1(WorkMsg msg){
        System.out.println(msg);
    }

    @RabbitListener(queues = QueueProperty.TOPIC_QUEUE_2)
    public void topicProcess2(WorkMsg msg){
        System.out.println(msg);
    }

    @RabbitListener(queues = QueueProperty.TOPIC_QUEUE_3)
    public void topicProcess3(WorkMsg msg){
        System.out.println(msg);
    }

}
