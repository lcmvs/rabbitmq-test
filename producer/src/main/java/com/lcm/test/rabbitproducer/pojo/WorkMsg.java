package com.lcm.test.rabbitproducer.pojo;

import lombok.Data;

/**
 * @description:
 * @author: lcm
 * @create: 2020-06-30 10:52
 **/

@Data
public class WorkMsg {

    private Long msgID;

    private String name;

    private Long timestamp;

}
