package com.hotel.app.advanced.kafka.producer;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KafkaProducerConfig {


    private Properties props;
    private KafkaProducer producer;

    public KafkaProducerConfig() {
        this.props = new Properties();
        loadProperties();
        createProducer();
    }


    public void loadProperties(){

        this.props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,KafkaConstants.BOOTSTRAP_SERVER);
        this.props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        this.props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        this.props.put(ProducerConfig.ACKS_CONFIG,KafkaConstants.ACKS);

    }


    public KafkaProducer createProducer(){
        this.producer = new KafkaProducer(this.props);
        return producer;
    }






}
