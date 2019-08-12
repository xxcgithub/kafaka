package com.example.kafaka2.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 2019/8/1
 * Time: 11:17
 */
public class MessCon {
    public static void main(String[] args) {
        Properties properties = new Properties();
        //链接服务器地址
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        //key 序列化
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        //value  序列化
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
        //创建消费组
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG,"111");
        //创建消费者
        KafkaConsumer<String ,String > kafkaConsumer = new KafkaConsumer<String, String>(properties);
        //从指定topic 消费
        kafkaConsumer.subscribe(Collections.singletonList("my_topic"));
        //指定 每  0.5秒  进行 拉取 一次 消费
        while (true){
            ConsumerRecords<String, String> poll = kafkaConsumer.poll(500);
            for (ConsumerRecord<String, String> stringStringConsumerRecord : poll) {
                System.out.println("所在分区："+stringStringConsumerRecord.partition()+"偏移量："+stringStringConsumerRecord.offset()
                +"key:"+stringStringConsumerRecord.key()+"value:"+stringStringConsumerRecord.value());
            }
            }
    }
}
