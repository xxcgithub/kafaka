package com.example.kafaka2.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: xxc
 * Date: 2019/8/1
 * Time: 10:46
 * @desc  kafka
 */
public class MessPro {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Properties properties = new Properties();
        //链接服务器地址
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        //key 序列化
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        //value  序列化
        properties.setProperty("value.serializer",StringSerializer.class.getName());
        //创建生产者
        KafkaProducer<String,String> kafkaProducer = new KafkaProducer<String, String>(properties);
        //创建消息记录
        ProducerRecord<String ,String > producerRecord = new ProducerRecord("my_topic",1,"test-key","myvalue") ;
        //发送

        //拓展消息确认机制   分为两种 同步  和  异步  异步的重新写一个

        //但是同步这里有个问题，如果kafka一直没有给确认，那么就会阻塞在这里，所以  get方法有个 时间，到达一定时间还没拿到确认，返回默认值，或者抛异常
        //这里的send  就是返回值
        Future<RecordMetadata> send = kafkaProducer.send(producerRecord);
        //recordMetadata 就是返回的元数据
        RecordMetadata recordMetadata = send.get();
        //通过返回元数据能拿到  发送之后的一些确认消息
        System.out.println("偏移量："+recordMetadata.offset()+"主题："+recordMetadata.topic());
        //清空
        kafkaProducer.flush();
        //关闭
        kafkaProducer.close();
    }
}
