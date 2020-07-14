package com.lcm.test.rabbitproducer;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: lcm
 * @create: 2020-07-13 15:26
 **/
@SpringBootTest
public class MandatoryTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void errorTest() throws InterruptedException {
        rabbitTemplate.convertAndSend("error", "error", "test");
        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

}
