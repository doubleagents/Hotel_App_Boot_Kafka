package com.hotel.app.advanced.kafka.producer;

import com.hotel.app.advanced.kafka.KafkaConfig;
import lombok.Data;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Properties;

@Configuration
@Data
public class KafkaProducerConfig {

    @Autowired
    private KafkaProducerConstants kafkaConstants;

    protected Properties props;

    private KafkaProducer producer;

    @PostConstruct
    public void loadProperties(){

        System.out.println("Bootstrap server: "+kafkaConstants.getBOOTSTRAP_SERVER());
        this.props = new Properties();

        this.props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        this.props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        this.props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaConstants.getBOOTSTRAP_SERVER());
        this.props.put(ProducerConfig.ACKS_CONFIG,kafkaConstants.getACKS());

        this.producer = new KafkaProducer(this.props);

    }

}
