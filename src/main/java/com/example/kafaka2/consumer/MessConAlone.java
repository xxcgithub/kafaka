package com.example.kafaka2.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 2019/8/1
 * Time: 11:17
 */
public class MessConAlone {
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
        //创建独立消费者,获取到 全部 分区
        List<PartitionInfo> partitionInfos = kafkaConsumer.partitionsFor("my-topic");

        //定义  list 接收 指定分区
        List<TopicPartition> list = new ArrayList<>();
        //for循环制定消费哪个分区
        for (PartitionInfo partitionInfo : partitionInfos) {
            if (partitionInfo.partition() != 2 && partitionInfo.partition() != 8){
                list.add(new TopicPartition(partitionInfo.topic(),partitionInfo.partition()));
            }
        }

        //从指定topic 消费
        //kafkaConsumer.subscribe(Collections.singletonList("my_topic"));
        //这里改为 一个单词  assign  分配
        kafkaConsumer.assign(list);
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
