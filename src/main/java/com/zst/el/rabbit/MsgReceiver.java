package com.zst.el.rabbit;

import com.zst.el.bean.vo.Message;
import com.zst.el.bean.vo.PrototypeFactory;
import com.zst.el.config.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author robert
 * @date 2021/4/15 11:59
 *
 * 1个生产者，1个消费者
 */
//@Component
//@RabbitListener(queues = RabbitConfig.QUEUE_A)
public class MsgReceiver {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitHandler
    public void process(String content) {
        //处理逻辑
        logger.info("接收处理队列A当中的消息： " + content);
    }

}

