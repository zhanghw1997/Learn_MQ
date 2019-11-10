package cn.zzu.springbootmq1.header;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Header模式
 * ① header模式我理解的是，通过HeadersExchange的验证才会放到队列中去
 * ②在绑定的时候，设置验证信息
 */

@Configuration
public class HeaderConfig {

    public final static String HEADER_EXCHANGE = "header_exchange";
    public final static String HEADER_QUEUE = "header_queue";

    /**
     * 向容器中注入队列
     * @return 队列
     */
    @Bean
    public Queue headersQueue(){
        return new Queue(HEADER_QUEUE,true);
    }

    /**
     * 向容器中注入HeadersExchange
     * @return
     */
    @Bean
    public HeadersExchange headersExchange(){
        return new HeadersExchange(HEADER_EXCHANGE);
    }

    /**
     * 向容器中注入绑定
     * @return 绑定对象
     */
    @Bean
    public Binding headresBinding(){
        Map<String,Object> map = new HashMap<>();
        map.put("header1","value1");
        map.put("header2","value2");
        /**
         * 把一个map类型的验证源放到绑定对象中
         */
        return BindingBuilder.bind(headersQueue()).to(headersExchange()).whereAll(map).match();
    }
}
