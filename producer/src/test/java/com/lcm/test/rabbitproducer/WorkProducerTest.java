package com.lcm.test.rabbitproducer;

import com.lcm.test.rabbitproducer.pojo.WorkMsg;
import com.lcm.test.rabbitproducer.work.WorkProducer;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description:
 * @author: lcm
 * @create: 2020-06-30 11:24
 **/
@SpringBootTest
public class WorkProducerTest {

    @Autowired
    WorkProducer workProducer;

    @Test
    public void test(){
        WorkMsg myMsg=new WorkMsg();
        myMsg.setMsgID(1L);
        myMsg.setName("lcm");
        myMsg.setTimestamp(System.currentTimeMillis());
        workProducer.send(myMsg);
    }

}
