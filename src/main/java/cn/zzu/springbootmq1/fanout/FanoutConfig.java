package cn.zzu.springbootmq1.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Fanout模式
 * ①也就是广播模式，
 * ②一个Exchange绑定多个Queue，然后把消息发送到Exchange中去，每个队列都会有这个消息
 * ③交换机：队列 = 1：n
 */
@Configuration
public class FanoutConfig {

    public final static String FANOUT_QUEUE_1 = "fanout_queue_1";
    public final static String FANOUT_QUEUE_2 = "fanout_queue_2";
    public final static String FANOUT_EXCAHNGE = "fanout_exchange";


    /**
     * 向容器注入队列1
     * @return  队列1
     */
    @Bean
    public Queue fanout_queue1(){
        return new Queue(FANOUT_QUEUE_1);
    }

    /**
     * 向容器中注入队列2
     * @return
     */
    @Bean
    public Queue fanout_queue2(){
        return new Queue(FANOUT_QUEUE_2);
    }

    /**
     * 向容器中注入一个FanoutExchange交换机
     * @return Fanout交换机
     */
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(FANOUT_EXCAHNGE);
    }

    /**
     * 把FanoutExchange和队列1绑定起来
     * @return 绑定对象
     */
    @Bean
    public Binding fanoutBind1(){
        return BindingBuilder.bind(fanout_queue1()).to(fanoutExchange());
    }

    /**
     * 把FanoutExchange和队列2绑定起来
     * @return 绑定对象
     */
    @Bean
    public Binding fanoutBind2(){
        return BindingBuilder.bind(fanout_queue2()).to(fanoutExchange());
    }
}
