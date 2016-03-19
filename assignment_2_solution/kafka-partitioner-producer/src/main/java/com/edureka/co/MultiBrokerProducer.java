package com.edureka.co;

import java.util.Properties;
import java.util.Random;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 * 
 * @author sagar.akshayan
 *
 */
public class MultiBrokerProducer {

	private static Producer<String, String> producer;

	public MultiBrokerProducer() {
		Properties props = PropertiesLoader.getKafkaProperties();
		producer = new Producer<String, String>(new ProducerConfig(props));
	}

	private String populateMessage() {
		StringBuilder sb = new StringBuilder();
		sb.append("Welcome to edureka kafka course" + "\n");
		sb.append("This is an example for publishing messages using kafka mutli broker producer"
				+ "\n");
		sb.append("Consume this message using the kafka consumer console"
				+ "\n");
		return sb.toString();
	}

	private void sendMessage(String topic) {
		try {
			
			Random rnd = new Random();
			for (long messCount = 0; messCount < 10; messCount++) {
				String message = populateMessage();
				Integer key = rnd.nextInt(255);
				message += "This message is for key - " + key;
				KeyedMessage<String, String> data = new KeyedMessage<String, String>(
						topic, key.toString(),message);
				System.out.println("Sending message -> " + message);
				producer.send(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			producer.close();
		}
	}

	//before execution
	// bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 2 --partitions 1 --topic kafka-multi-broker-topic-1
	//after execution
	// bin/kafka-console-consumer.sh --zookeeper localhost:2181 --topic kafka-multi-broker-topic-1 --from-beginning
	public static void main(String[] args) {
		System.out
				.println("Program to publish  message to Kafka multi broker producer");
		MultiBrokerProducer sp = new MultiBrokerProducer();
		// This topic will be created if not exists
		// Remove the topic if already exists from zookeeper
		sp.sendMessage("kafka-multi-broker-topic-1");
		System.out.println("Message sent succesfully");

	}
}
