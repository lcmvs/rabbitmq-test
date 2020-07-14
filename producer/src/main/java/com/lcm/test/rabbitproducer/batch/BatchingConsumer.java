package com.lcm.test.rabbitproducer.batch;

import com.lcm.test.rabbitproducer.pojo.WorkMsg;
import com.lcm.test.rabbitproducer.property.QueueProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:
 * @author: lcm
 * @create: 2020-07-13 17:44
 **/
@Slf4j
@Component
public class BatchingConsumer {

    //@RabbitListener(queues = QueueProperty.BATCH_QUEUE)
    public void batchOneProcess(WorkMsg entity){
        log.info("成功消费{{}}条消息:{{}}",1,entity);
    }

    @RabbitListener(queues = QueueProperty.BATCH_QUEUE , containerFactory = "myBatchSimpleRabbitListenerContainerFactory")
    public void batchListProcess(List<WorkMsg> list){
        log.info("成功消费{{}}条消息:{{}}",list.size(),list);
    }

}
