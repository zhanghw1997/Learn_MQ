package cn.zzu.springbootmq1.direct;

import cn.zzu.springbootmq1.SpringbootMq1ApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class MessageSenderTest extends SpringbootMq1ApplicationTests {

    @Autowired
    private MessageSender messageSender;


    @Test
    public void testSend(){
        messageSender.send();
    }
}