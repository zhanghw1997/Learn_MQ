package cn.zzu.springbootmq1.header;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * headers模式的接收者
 */
@Service
public class HeadersMessageReceiver {

    /**
     * 接收函数的形参为byte的数组，因为发送的时候是以byte的数组发送的
     * @param msg
     */
    @RabbitListener(queues = HeaderConfig.HEADER_QUEUE)
    public void reveiver(byte[] msg){
        System.out.println("我是HeadersQueue1接收："+ new String(msg));
    }
}
