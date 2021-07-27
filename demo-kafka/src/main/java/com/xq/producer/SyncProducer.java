package com.xq.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class SyncProducer {
    public static void main(String[] args) {

        Properties properties = new Properties();

        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"106.14.32.152:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> Producer = new KafkaProducer<String, String>(properties);

        for (int i = 0; i < 10; i++) {
            Future<RecordMetadata> future = Producer.send(new ProducerRecord<String, String>("third", "world-" + i),
                    (metadata, exception) -> {
                        if (exception == null) {
                            System.out.println("----------------------------");
                            System.out.println(metadata.offset() + "  " + metadata.partition() + " ");
                        } else {
                            exception.printStackTrace();
                        }
                    });

            try {
                RecordMetadata recordMetadata = future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }


        Producer.close();
    }
}
