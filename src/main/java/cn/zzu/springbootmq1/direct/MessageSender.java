package cn.zzu.springbootmq1.direct;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {

    /**
     * 定义amqp模板
     */
    @Autowired
    private AmqpTemplate amqpTemplate;

    private final static String DIRECT_MSG = "我是direct模式";

    /**
     * 发送消息到消息队列
     */
    public void send(){
        amqpTemplate.convertAndSend(DirectConfig.DIRECT_QUEUE,DIRECT_MSG);
    }
}
