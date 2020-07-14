package com.lcm.test.rabbitproducer;

import com.lcm.test.rabbitproducer.ProducerConfirm.AsynConfirmProducer;
import com.lcm.test.rabbitproducer.pojo.WorkMsg;
import com.rabbitmq.client.ConfirmCallback;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitOperations;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: lcm
 * @create: 2020-07-13 16:19
 **/
@SpringBootTest
public class ProducerConfirmTest {
    
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AsynConfirmProducer asynConfirmProducer;
    
    @Test
    public void synTest(){


    }

    @Test
    public void asynTest() throws InterruptedException {
        WorkMsg msg=new WorkMsg();
        msg.setMsgID(1L);
        msg.setName("lcm");
        msg.setTimestamp(System.currentTimeMillis());
        asynConfirmProducer.synProducer(msg);
        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

}
