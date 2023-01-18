package com.hotel.app.advanced.kafka.producer;

import com.hotel.app.advanced.model.Hotel;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private KafkaProducerConfig producerConfig;

    @Autowired
    public KafkaProducerService(KafkaProducerConfig producerConfig){
        this.producerConfig = producerConfig;
    }
    public void pushToTopic(Hotel hotel){

        createAndPush(KafkaConstants.HOTEL_TOPIC,hotel.getHotelId(),hotel.toString());
    }

    private void createAndPush(String topic,String key,String value){
        ProducerRecord<String,String> record = new ProducerRecord<String,String>(topic,key,value);
        KafkaProducer producer = this.producerConfig.createProducer();
        producer.send(record, new ProducerCallback());

        producer.flush();


    }
}
