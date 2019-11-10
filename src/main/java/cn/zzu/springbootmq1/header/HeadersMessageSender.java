package cn.zzu.springbootmq1.header;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Headers模式的发送者
 */
@Service
public class HeadersMessageSender {

    public final static String HEADERS_MSG = "headers_msg";

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        /**
         * 创建MessageProperties，把消息头放进去
         */
        MessageProperties msp = new MessageProperties();
        msp.setHeader("header1","value1");
        msp.setHeader("header2","value2");
        /**
         * 创建Message对象，把要发送的信息和MessageProperties放进去
         */
        Message obj = new Message(HEADERS_MSG.getBytes(),msp);
        /**
         * 发送这个Message对象
         */
        amqpTemplate.convertAndSend(HeaderConfig.HEADER_EXCHANGE,"",obj);
    }
}
