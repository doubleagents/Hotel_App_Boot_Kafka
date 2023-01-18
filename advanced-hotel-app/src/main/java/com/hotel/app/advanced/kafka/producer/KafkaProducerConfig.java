package com.hotel.app.advanced.kafka.producer;

import lombok.Data;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import java.util.Properties;

@Configuration
@Data
public class KafkaProducerConfig {

    @Autowired
    private KafkaConstants kafkaConstants;
    private Properties props;
    private KafkaProducer producer;

    @Autowired
    public KafkaProducerConfig() {
        this.props = new Properties();
    }


    @PostConstruct
    public void loadProperties(){

        System.out.println("Bootstrap server: "+kafkaConstants.getBOOTSTRAP_SERVER());
        this.props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaConstants.getBOOTSTRAP_SERVER());
        this.props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        this.props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        this.props.put(ProducerConfig.ACKS_CONFIG,kafkaConstants.getACKS());

        this.producer = new KafkaProducer(this.props);

    }

}
