package com.flnn.spark.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * 模拟生成数据，发送到kafka
 */
public class KafkaProducerTest {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,KafkaProperties.BROKER_LIST);
        properties.setProperty("acks","all");
        properties.setProperty(ProducerConfig.RETRIES_CONFIG, "2");
        //properties.setProperty(ProducerConfig.BATCH_SIZE_CONFIG,"16384");
        properties.setProperty(ProducerConfig.LINGER_MS_CONFIG, "0");
        properties.setProperty(ProducerConfig.BUFFER_MEMORY_CONFIG, "33554432");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        Producer producer = new KafkaProducer(properties);

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                String key = "key-" + i;
                String value= "test-kafka-" + i;
                producer.send(new ProducerRecord(KafkaProperties.TOPIC, key, value), (metadata,exception)->{
                    System.out.println(metadata);
                });
            }
        });
        thread.start();

        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
