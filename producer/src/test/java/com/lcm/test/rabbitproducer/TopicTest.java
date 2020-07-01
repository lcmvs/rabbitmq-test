package com.lcm.test.rabbitproducer;

import com.lcm.test.rabbitproducer.direct.DirectProcuder;
import com.lcm.test.rabbitproducer.pojo.WorkMsg;
import com.lcm.test.rabbitproducer.topic.TopicProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description:
 * @author: lcm
 * @create: 2020-06-30 11:24
 **/
@SpringBootTest
public class TopicTest {

    @Autowired
    TopicProducer topicProducer;

    @Test
    public void test(){
        WorkMsg myMsg=new WorkMsg();
        myMsg.setMsgID(0L);
        myMsg.setName("lcm");
        myMsg.setTimestamp(System.currentTimeMillis());
        topicProducer.send(myMsg);
        myMsg.setMsgID(1L);
        topicProducer.send1(myMsg);
        myMsg.setMsgID(2L);
        topicProducer.send2(myMsg);
    }

}
