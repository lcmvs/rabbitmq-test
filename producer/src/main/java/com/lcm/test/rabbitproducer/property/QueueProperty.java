package com.lcm.test.rabbitproducer.property;

import lombok.Data;

/**
 * @description:
 * @author: lcm
 * @create: 2020-06-30 10:58
 **/

public class QueueProperty {

    /**
     * 死信队列交换机
     */
    public static final String DEAD_EXCHANGE="dead.exchange";

    /**
     * work的死信队列
     */
    public static final String DEAD_WORK_QUEUE="lcm.work.dead.queue";

    /**
     * work队列
     */
    public static final String WORK_QUEUE="lcm.work.queue";


    /**
     * direct队列1
     */
    public static final String DIRECT_QUEUE_1="lcm.direct.queue.1";

    /**
     * direct队列2
     */
    public static final String DIRECT_QUEUE_2="lcm.direct.queue.2";

    /**
     * direct交换机
     */
    public static final String DIRECT_EXCHANGE="lcm.direct.exchange";


    /**
     * topic队列1
     */
    public static final String TOPIC_QUEUE_1="lcm.topic.queue.1";

    /**
     * topic队列2
     */
    public static final String TOPIC_QUEUE_2="lcm.topic.queue.2";

    /**
     * topic队列2
     */
    public static final String TOPIC_QUEUE_3="lcm.topic.queue.3";

    /**
     * topic交换机
     */
    public static final String TOPIC_EXCHANGE="lcm.topic.exchange";


    /**
     * pubsub队列1
     */
    public static final String PUBSUB_QUEUE_1="lcm.pubsub.queue.1";

    /**
     * pubsub队列2
     */
    public static final String PUBSUB_QUEUE_2="lcm.pubsub.queue.2";

    /**
     * pubsub队列2
     */
    public static final String PUBSUB_QUEUE_3="lcm.pubsub.queue.3";

    /**
     * pubsub交换机
     */
    public static final String PUBSUB_EXCHANGE="lcm.pubsub.exchange";

}
