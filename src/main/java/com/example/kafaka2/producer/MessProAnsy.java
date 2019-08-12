package com.example.kafaka2.producer;

import org.apache.kafka.clients.producer.*;
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
public class MessProAnsy {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Properties properties = new Properties();
        //链接服务器地址
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        //key 序列化
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //value  序列化
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        //创建生产者
        KafkaProducer<String,String> kafkaProducer = new KafkaProducer<String, String>(properties);
        //创建消息记录
        ProducerRecord<String ,String > producerRecord = new ProducerRecord("my_topic",1,"test-key","myvalue") ;
        //发送
         //异步  这里用回调
        kafkaProducer.send(producerRecord, new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {

                if (null != e){
                    e.printStackTrace();
                }
                if (null != recordMetadata){

                }
            }
        });
        //清空
        kafkaProducer.flush();
        //关闭
        kafkaProducer.close();
    }
}
