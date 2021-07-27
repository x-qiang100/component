package com.xq.Consumer;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;

//自定义存储offset
public class CommitOffset{
    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"106.14.32.152:9092");
        //自动提交offset延迟
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG , "1000");
        //开启自动提交
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,false);
        //key value反序列化
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG  , "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG  , "org.apache.kafka.common.serialization.StringDeserializer");
        //消费者组
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,"mySecond");
        //没有初始偏移量 | 不存在当前偏移量
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        String topic  =  "first";

        consumer.subscribe(Arrays.asList("first", "third"), new ConsumerRebalanceListener() {
            @Override
            public void onPartitionsRevoked(Collection<TopicPartition> partitions) {

            }

            @Override
            public void onPartitionsAssigned(Collection<TopicPartition> partitions) {

            }
        });


        while (true){
            //拉取数据
            ConsumerRecords<String, String> poll = consumer.poll(Duration.ZERO.plusSeconds(1));
            //解析并打印
            for (ConsumerRecord<String, String> record : poll) {
                System.out.println(record.topic()+"--"+record.key()+"--" + record.value());
            }
        }
        //关闭连接

    }

    static long getOffset(TopicPartition partition){

        return 0;

    }

    static void commitOffset(Map<TopicPartition , Long> topicPartitionLongMap){


    }

}
