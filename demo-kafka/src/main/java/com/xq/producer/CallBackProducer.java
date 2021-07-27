package com.xq.producer;

import org.apache.kafka.clients.producer.*;
import java.util.ArrayList;
import java.util.Properties;

public class CallBackProducer {



    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"106.14.32.152:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String, String> Producer = new KafkaProducer<String, String>(properties);

        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("cc");
        for (int i = 0; i < 10; i++) {

            Producer.send(new ProducerRecord<String, String>("second", list.get(i%2),"world-" + i),
                    (metadata, exception) -> {
                if(exception == null) {
                    System.out.println("----------------------------");
                    System.out.println(metadata.offset()+"  "+metadata.partition()+" ");
                }else {
                    exception.printStackTrace();
                }
            }) ;

        }

        Producer.close();
    }

}
