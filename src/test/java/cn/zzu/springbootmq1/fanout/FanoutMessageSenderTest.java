package cn.zzu.springbootmq1.fanout;

import cn.zzu.springbootmq1.SpringbootMq1ApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class FanoutMessageSenderTest extends SpringbootMq1ApplicationTests {

    @Autowired
    private FanoutMessageSender fanoutMessageSender;

    @Test
    public void testFanout(){
        fanoutMessageSender.send();
    }
}