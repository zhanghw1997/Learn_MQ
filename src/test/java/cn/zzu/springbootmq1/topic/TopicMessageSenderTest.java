package cn.zzu.springbootmq1.topic;

import cn.zzu.springbootmq1.SpringbootMq1ApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TopicMessageSenderTest extends SpringbootMq1ApplicationTests {

    @Autowired
    private TopicMessageSender messageSender;


    @Test
    public void testTopic(){
        messageSender.send();
    }
}