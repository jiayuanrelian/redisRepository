package com.sweet.redis;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try {
            DefaultMQProducer defaultMQProducer = new DefaultMQProducer("producer1");
            defaultMQProducer.setVipChannelEnabled(false);
            defaultMQProducer.setNamesrvAddr("47.98.59.135:9876");
            defaultMQProducer.start();
            for (int i = 0; i <10000 ; i++) {
                Message msg = new Message("TopicTest",// topic//
                        "TagA",// tag
                        ("Hello RocketMQ").getBytes(RemotingHelper.DEFAULT_CHARSET));

                SendResult sendResult = defaultMQProducer.send(msg);
                System.out.print(i+"的结果："+sendResult.toString());
            }
            defaultMQProducer.shutdown();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
    }
}
