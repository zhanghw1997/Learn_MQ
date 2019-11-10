package cn.zzu.springbootmq1.topic;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicMessageReceiver {

    @RabbitListener(queues = TopicConfig.TOPIC_QUEQUE_1)
    public void receiver1(String message){
        System.out.println("我是topic_queue1"+message);
    }

    @RabbitListener(queues = TopicConfig.TOPIC_QUEQUE_2)
    public void receiver2(String message){
        System.out.println("我是topic_queue2"+message);
    }
}
