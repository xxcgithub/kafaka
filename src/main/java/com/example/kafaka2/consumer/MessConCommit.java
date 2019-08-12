package com.example.kafaka2.consumer;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 2019/8/1
 * Time: 11:17
 */
public class MessConCommit {
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
        //从指定topic 消费   同时 后期这里加了个  消费回调
        kafkaConsumer.subscribe(Collections.singletonList("my_topic"), new ConsumerRebalanceListener() {
            @Override
            public void onPartitionsRevoked(Collection<TopicPartition> collection) {
                System.out.println("再均衡之前");
                //在均衡之前 ，进行一次 全部提交
                kafkaConsumer.commitSync();
            }

            @Override
            public void onPartitionsAssigned(Collection<TopicPartition> collection) {

                System.out.println("再均衡之后");
                System.out.println(collection.spliterator());
            }
        });

        //消费者提交偏移量 有两种方式，同步和异步

        //kafkaConsumer.commitSync();
        //kafkaConsumer.commitAsync();

        //同时可以自定义 提交偏移量  下面等到提交 偏移量的时候 就可以 传这个 metadataMap
        Map<TopicPartition, OffsetAndMetadata> metadataMap = new HashMap<>();
        metadataMap.put(new TopicPartition("my-topic",0),new OffsetAndMetadata(0,"id"));

        //指定 每  0.5秒  进行 拉取 一次 消费
        try {
            while (true){
                ConsumerRecords<String, String> poll = kafkaConsumer.poll(500);
                for (ConsumerRecord<String, String> stringStringConsumerRecord : poll) {
                    System.out.println("所在分区："+stringStringConsumerRecord.partition()+"偏移量："+stringStringConsumerRecord.offset()
                    +"key:"+stringStringConsumerRecord.key()+"value:"+stringStringConsumerRecord.value());
                    System.out.println("消费完毕消息");
                }
                //这个就是制定提交的偏移量
                //kafkaConsumer.commitSync(metadataMap);
                kafkaConsumer.commitAsync();
                }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                kafkaConsumer.commitSync();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                kafkaConsumer.close();
            }
        }
    }
}
