package com.xq.interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Date;
import java.util.Map;
import java.util.Timer;

public class TimeInterceptor implements ProducerInterceptor<String,String> {

    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(date);
        System.out.println(date.toString());

        Timer timer = new Timer();
        System.out.println(timer.purge());
    }

    @Override
    public void configure(Map<String, ?> configs) {

    }

    @Override
    public ProducerRecord<String,String> onSend(ProducerRecord<String,String> record) {


        ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(
                record.topic(),record.partition(),record.key(),System.currentTimeMillis()+","+record.value()
        );
        return producerRecord;
    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {

    }

    @Override
    public void close() {
        System.out.println("时间戳添加完毕");
    }




}
