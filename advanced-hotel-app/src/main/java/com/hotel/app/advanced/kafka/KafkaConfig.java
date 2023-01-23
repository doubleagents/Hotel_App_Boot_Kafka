package com.hotel.app.advanced.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KafkaConfig {

    protected Properties props;

    public void loadProperties(){


    }
}
