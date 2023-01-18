# Advanced Hotel App

# Introduction:

**Hotel App is going to serve reservation backend for hotel services.
This App has been built as a Springboot Microservice with 
Mongo DB as backend Document DB. We are using AWS EC2 for deployment.
Kafka will be used to serve analytics on type of hotel requirement, popularity of
properties and popular destinations**


## Kafka - Commands


### Zookeeper Start: 
    zookeeper-server-start.sh -daemon /home/ec2-user/kafka_2.13-3.2.0/kafka_2.13-3.2.0/config/zookeeper.properties
### Kafka Start: 
    kafka-server-start.sh /home/ec2-user/kafka_2.13-3.2.0/kafka_2.13-3.2.0/config/server.properties

### Kafka Topic:  
    kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 3 --topic hotel_analytics