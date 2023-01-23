package com.hotel.app.advanced.kafka.consumer;

import com.hotel.app.advanced.kafka.producer.KafkaProducerConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import java.time.Duration;
import java.util.Arrays;

@Slf4j
public class KafkaConsumerRunner implements CommandLineRunner {

    private KafkaProducerConstants kafkaProducerConstants;
    private KafkaConsumerConfig config;

    @Autowired
    public KafkaConsumerRunner(KafkaConsumerConfig config,KafkaProducerConstants kafkaProducerConstants){

        this.kafkaProducerConstants = kafkaProducerConstants;
        this.config=config;
    }

    @Override
    public void run(String... strings) {

        KafkaConsumer<String,String> consumer= new KafkaConsumer<String,String>(config.getProps());

        try {

            consumer.subscribe(Arrays.asList(kafkaProducerConstants.getHOTEL_TOPIC()));

            while (true) {
                ConsumerRecords<String, String> records =
                        consumer.poll(Duration.ofMillis(100));

                for (ConsumerRecord<String, String> record : records) {
                    log.info("Key: " + record.key() + ", Value: " + record.value());
                    log.info("Partition: " + record.partition() + ", Offset:" + record.offset());
                }
            }

        } catch (Exception e) {
            log.error("Unexpected exception", e);
            System.out.println(" Unexpected Exception from Consumer ::"+e.getMessage());
        } finally {
            consumer.close(); // this will also commit the offsets if need be.
            System.out.println("The consumer is now gracefully closed.");
            log.info("The consumer is now gracefully closed.");
        }
    }
}
