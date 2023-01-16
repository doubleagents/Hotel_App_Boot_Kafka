package com.hotel.app.advanced.kafka.producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

public class ProducerCallback implements Callback {

    @Override
    public void onCompletion(RecordMetadata recordMetadata,
                             Exception e) {

        System.out.println("Metadata: -> "+recordMetadata.topic()
                + ", "+recordMetadata.offset()
                + ", "+recordMetadata.offset());




    }
}
