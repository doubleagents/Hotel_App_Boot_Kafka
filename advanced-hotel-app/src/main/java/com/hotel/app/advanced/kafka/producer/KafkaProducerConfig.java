package com.hotel.app.advanced.kafka.producer;

import lombok.Data;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import java.util.Properties;

@Configuration
@Data
public class KafkaProducerConfig {


    @Value("kafka.bootstrap.server")
    private String BOOTSTRAP_SERVER;

    @Value("kafka.acks.default")
    private String ACKS;

    @Value("kafka.topic.hotel")
    private String HOTEL_TOPIC;
    private Properties props;
    private KafkaProducer producer;

    public KafkaProducerConfig() {
        this.props = new Properties();
        loadProperties();
        this.producer = new KafkaProducer(this.props);
    }


    public void loadProperties(){

        this.props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,this.BOOTSTRAP_SERVER);
        this.props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        this.props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        this.props.put(ProducerConfig.ACKS_CONFIG,this.ACKS);

    }

}
