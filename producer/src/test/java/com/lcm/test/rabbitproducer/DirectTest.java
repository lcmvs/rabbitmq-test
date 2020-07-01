package com.lcm.test.rabbitproducer;

import com.lcm.test.rabbitproducer.direct.DirectProcuder;
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
public class DirectTest {

    @Autowired
    DirectProcuder directProcuder;

    @Test
    public void test(){
        WorkMsg myMsg=new WorkMsg();
        myMsg.setMsgID(0L);
        myMsg.setName("lcm");
        myMsg.setTimestamp(System.currentTimeMillis());
        directProcuder.send(myMsg);
        myMsg.setMsgID(1L);
        directProcuder.send1(myMsg);
        myMsg.setMsgID(2L);
        directProcuder.send2(myMsg);
    }

}
