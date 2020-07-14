package com.lcm.test.rabbitproducer.ProducerConfirm;

import com.lcm.test.rabbitproducer.pojo.WorkMsg;
import com.lcm.test.rabbitproducer.property.QueueProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: lcm
 * @create: 2020-07-14 11:32
 **/
@Slf4j
@Component
public class AsynConfirmProducer {

    @Autowired
    MyConfirmCallback myConfirmCallback;

    @Autowired
    MyReturnCallback myReturnCallback;

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void synProducer(WorkMsg msg){
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback(myConfirmCallback);
        rabbitTemplate.setReturnCallback(myReturnCallback);
        rabbitTemplate.convertAndSend(QueueProperty.DIRECT_EXCHANGE,"error", msg);
    }

}
