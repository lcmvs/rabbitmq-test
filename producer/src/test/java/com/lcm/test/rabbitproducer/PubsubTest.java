package com.lcm.test.rabbitproducer;

import com.lcm.test.rabbitproducer.direct.DirectProcuder;
import com.lcm.test.rabbitproducer.pojo.WorkMsg;
import com.lcm.test.rabbitproducer.publish.FanoutProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description:
 * @author: lcm
 * @create: 2020-07-01 13:52
 **/
@SpringBootTest
public class PubsubTest {

    @Autowired
    FanoutProducer fanoutProducer;

    @Test
    public void test() throws InterruptedException {
        WorkMsg myMsg=new WorkMsg();
        myMsg.setMsgID(0L);
        myMsg.setName("lcm");
        myMsg.setTimestamp(System.currentTimeMillis());
        fanoutProducer.send1(myMsg);
        myMsg.setMsgID(1L);
        fanoutProducer.send2(myMsg);
        myMsg.setMsgID(2L);
        fanoutProducer.send3(myMsg);
        Thread.sleep(2000);
    }
}
