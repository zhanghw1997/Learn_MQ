package cn.zzu.springbootmq1.header;


import cn.zzu.springbootmq1.SpringbootMq1ApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class HeadersMessageSenderTest extends SpringbootMq1ApplicationTests {

    @Autowired
    private HeadersMessageSender messageSender;

    @Test
    public void test(){
        messageSender.send();
    }
}