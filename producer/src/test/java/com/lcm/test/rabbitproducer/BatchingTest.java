package com.lcm.test.rabbitproducer;

import com.lcm.test.rabbitproducer.batch.BatchingProducer;
import com.lcm.test.rabbitproducer.pojo.WorkMsg;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.BatchingRabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description:
 * @author: lcm
 * @create: 2020-07-13 17:51
 **/
@Slf4j
@SpringBootTest
public class BatchingTest {

    @Autowired
    BatchingProducer batchingProducer;

    @Test
    public void batchSend() throws InterruptedException {
        for(int i=0;i<10;i++){
            WorkMsg msg=new WorkMsg();
            msg.setMsgID((long)i);
            msg.setName("lcm");
            msg.setTimestamp(System.currentTimeMillis());
            batchingProducer.send(msg);
        }
        log.info("成功发送{{}}条消息",10);
        Thread.sleep(2000L);
    }

}
