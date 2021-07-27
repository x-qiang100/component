package com.xq.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.protocol.types.Field;

import java.util.ArrayList;
import java.util.Properties;

public class InterceptorProducer {

    public static void main(String[] args) {
        //1、创建kafka配置信息
        Properties properties = new Properties();
        //指定连接集群
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"106.14.32.152:9092");
        //集群broker地址，多个broker地址逗号隔开
        //设置生产者id
        properties.put(ProducerConfig.CLIENT_ID_CONFIG,"KafkaProducerDemo");
        //设置发送消息ack模式
        properties.put(ProducerConfig.ACKS_CONFIG,"all");
        //key序列化类
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");
        //value序列化类
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");
        //设置批量发送消息的size
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG, 5);
        //延迟发送的时间，延迟时间内的消息一起发送到broker'
        properties.put(ProducerConfig.LINGER_MS_CONFIG, 1 );
        //每次请求最大的字节数
        properties.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, 1024);

        //拦截器添加
        //有顺序
        ArrayList<String> list = new ArrayList<>();
        list.add("com.xq.interceptor.CounterInterceptor");
        list.add("com.xq.interceptor.TimeInterceptor");
        properties.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG,
                list);


        //2、创建生产者对象
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        //3、发送数据

        String topic = "first";
        producer.send(new ProducerRecord<String, String>(topic,"hello" ) );
        for (int i = 0; i < 10; i++) {
            producer.send(new ProducerRecord<String, String>(topic,"key","hello"+i ) );
        }

        //4、关闭资源

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//
//        }


        producer.close();


    }

}
