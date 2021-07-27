package com.xq.producer;

import com.xq.partitioner.MyPartitioner;
import org.apache.kafka.clients.producer.*;

import java.util.ArrayList;
import java.util.Properties;

public class PartitionProducer {


    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"106.14.32.152:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");

        //添加分区器
        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG,"com.xq.partitioner.MyPartitioner");

        String topic = "third";

        KafkaProducer<String, String> Producer = new KafkaProducer<String, String>(properties);
        for (int i = 0; i < 10; i++) {
            Producer.send(new ProducerRecord<>(topic,i+"hh", "!" + i), new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    if(exception == null) {
                        System.out.println("----------------------------");
                        System.out.println(metadata.offset()+"  "+metadata.partition());
                    }else {
                        exception.printStackTrace();
                    }
                }
            });
        }

        Producer.close();

    }

}
