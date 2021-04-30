package com.zst.el.controller;


import com.zst.el.kafka.Producer;
import com.zst.el.rabbit.MsgReceiver;
import com.zst.el.rabbit.MyProducer;
import com.zst.el.service.ISystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;
@Controller
public class BaseController {
    /* 数据存储 */
    protected Map<String, Object> info = new HashMap<String, Object>();

    @Autowired
    protected ISystemUserService userService;
    //kafka 的生产者
//    @Autowired
//    protected Producer producer;

    //rabbitMQ 的生产者
    @Autowired
    protected MyProducer myProducer;
}
