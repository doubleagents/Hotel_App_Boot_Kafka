package com.hotel.app.advanced.kafka.consumer;

import com.hotel.app.advanced.kafka.KafkaConfig;
import lombok.Data;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Properties;

@Configuration
@Data
public class KafkaConsumerConfig {


    private KafkaConsumerConstants kafkaConstants;

    private Properties props;

    @Autowired
    public KafkaConsumerConfig(KafkaConsumerConstants kafkaConstants){
        this.kafkaConstants = kafkaConstants;
    }

    @PostConstruct
    public void loadProperties(){

        this.props = new Properties();
        this.props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        this.props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        this.props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaConstants.getBOOTSTRAP_SERVER());
        this.props.put(ConsumerConfig.GROUP_ID_CONFIG,kafkaConstants.getGROUP_ID());
        this.props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,kafkaConstants.getREAD_OFFSET());


    }
}
