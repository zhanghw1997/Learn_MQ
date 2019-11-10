package cn.zzu.springbootmq1.direct;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ReceiverMessage {


    @RabbitListener(queues = DirectConfig.DIRECT_QUEUE)
    public void receiver(String msg){
        System.out.println(msg);
    }
}
