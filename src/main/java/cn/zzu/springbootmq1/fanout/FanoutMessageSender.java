package cn.zzu.springbootmq1.fanout;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 发送消息service
 */
@Service
public class FanoutMessageSender {

    private final static String FANOUT_MSG = "fanout_msg";

    /**
     * 使用AmqpTemplate操纵发送消息
     */
    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送消息方法
     */
    public void send(){
        /**
         * convertAndSend没有Routingkey，所以“”
         */
        amqpTemplate.convertAndSend(FanoutConfig.FANOUT_EXCAHNGE,"",FANOUT_MSG);
    }
}
