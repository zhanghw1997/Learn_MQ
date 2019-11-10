package cn.zzu.springbootmq1.fanout;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class FanoutMessageReceiver {

    @RabbitListener(queues = FanoutConfig.FANOUT_QUEUE_1)
    public void receiver1(String message){
        System.out.println("我是fanout_queue1--->"+message);
    }

    @RabbitListener(queues = FanoutConfig.FANOUT_QUEUE_2)
    public void receiver2(String message){
        System.out.println("我是fanout_queue2--->"+message);
    }
}
