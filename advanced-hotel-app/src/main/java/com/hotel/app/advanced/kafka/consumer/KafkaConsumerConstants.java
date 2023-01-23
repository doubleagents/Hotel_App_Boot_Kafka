package com.hotel.app.advanced.kafka.consumer;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@NoArgsConstructor
public class KafkaConsumerConstants {

    @Value("${kafka.bootstrap.server}")
    private String BOOTSTRAP_SERVER;

    @Value("${kafka.consumer.groupID}")
    private String GROUP_ID;

    @Value("${kafka.consumer.offset}")
    private String READ_OFFSET;


}
