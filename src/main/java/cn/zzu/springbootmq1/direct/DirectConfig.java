package cn.zzu.springbootmq1.direct;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * direct模式
 * ①直连服务，不需要交换机
 * ②数据直接放进队列
 */
@Configuration
public class DirectConfig {

    public final static String DIRECT_QUEUE="direct_queue";


    /**
     * 向容器中注入一个队列
     * @return
     */
    @Bean
    public Queue queue(){
        return new Queue(DIRECT_QUEUE);
    }
}
