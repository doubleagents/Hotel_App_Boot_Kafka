package com.hotel.app.advanced.kafka.producer;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConstants {

    @Value("${kafka.bootstrap.server}")
    private String BOOTSTRAP_SERVER;

    @Value("${kafka.acks.default}")
    private String ACKS;

    @Value("${kafka.topic.hotel}")
    private String HOTEL_TOPIC;

    public KafkaConstants(){

    }

    public void setBOOTSTRAP_SERVER(String BOOTSTRAP_SERVER) {
        this.BOOTSTRAP_SERVER = BOOTSTRAP_SERVER;
    }

    public void setACKS(String ACKS) {
        this.ACKS = ACKS;
    }

    public void setHOTEL_TOPIC(String HOTEL_TOPIC) {
        this.HOTEL_TOPIC = HOTEL_TOPIC;
    }

    public String getBOOTSTRAP_SERVER() {
        return BOOTSTRAP_SERVER;
    }

    public String getACKS() {
        return ACKS;
    }

    public String getHOTEL_TOPIC() {
        return HOTEL_TOPIC;
    }
}
