package cn.zzu.springbootmq1.topic;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * topic模式下的Send服务
 */
@Service
public class TopicMessageSender {

    private final static String TOPIC_MSG = "topic_msg";

    @Autowired
    private AmqpTemplate amqpTemplate;


    public void send(){
        /**
         * topic模式，交换机和routing_key指定一个queue，不需要填写Queue
         */
        amqpTemplate.convertAndSend(TopicConfig.TOPIC_EXCHANGE,"topic.key1",TOPIC_MSG+"key1");
        amqpTemplate.convertAndSend(TopicConfig.TOPIC_EXCHANGE,"topic.key2",TOPIC_MSG+"key2");
    }
}
