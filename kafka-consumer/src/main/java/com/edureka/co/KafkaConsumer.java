package com.edureka.co;

import com.edureka.co.listener.ConsumerListener;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author sagar.akshayan
 */
public class KafkaConsumer {

    private void startConsumeMessagesFromTopic(String topic) {
        try {
            ConsumerListener consumerListener = new ConsumerListener();
            LinkedBlockingQueue<String> queue = consumerListener.consume(topic);
            System.out.println("Consuming messages from topic -> " + topic);
            String msg = queue.take();
            System.out.println(msg);
            while ((msg = queue.take()) != null) {
                System.out.println(msg);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //start the producer and enter messages to consume
    //bin/kafka-nsole-producer.sh --broker-list localhost:9092 --topic testtopic

    public static final void main(String[] args) {
        KafkaConsumer consumer = new KafkaConsumer();
        String topic = "testtopic";
        consumer.startConsumeMessagesFromTopic(topic);
    }


}
