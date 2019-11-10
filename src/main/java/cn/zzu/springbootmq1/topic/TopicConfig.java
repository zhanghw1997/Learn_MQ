package cn.zzu.springbootmq1.topic;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Topic模式
 * ①主要是每个队列有个Routingkey，相当于Queue的别名（我的理解），通过RoutingKey和Exchange定义到Queue
 * ②  TopicExchange---> Queue ---> RoutingKey
 */
@Configuration
public class TopicConfig {

    public final static String TOPIC_QUEQUE_1 = "topic_queue_1";
    public final static String TOPIC_QUEQUE_2 = "topic_queue_2";
    public final static String TOPIC_EXCHANGE = "topic_exchange";
    public final static String ROUTING_KEY_1 = "topic.key1";
    public final static String ROUTING_KEY_2 = "topic.#";

    /**
     * 向容器中注入队列1
     * @return 队列1
     */
    @Bean
    public Queue topic_queue1(){
        return new Queue(TOPIC_QUEQUE_1);
    }

    /**
     * 向容器中注入队列2
     * @return 队列2
     */
    @Bean
    public Queue topic_queue2(){
        return new Queue(TOPIC_QUEQUE_2);
    }

    /**
     * 向容器中注入topicExchange
     * @return topicExchange
     */
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    /**
     * 把topicExchange,Queue1,RoutingKey1绑定在一起
     * @return 绑定对象1
     */
    @Bean
    public Binding topicBinding1(){
        return BindingBuilder.bind(topic_queue1()).to(topicExchange()).with(ROUTING_KEY_1);
    }

    /**
     * 把topicExchange,Queue2,RoutingKey2绑定在一起
     * @return 绑定对象2
     */
    @Bean
    public Binding topicBinding2(){
        return BindingBuilder.bind(topic_queue2()).to(topicExchange()).with(ROUTING_KEY_2);
    }

}
