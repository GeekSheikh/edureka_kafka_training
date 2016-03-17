package com.edureka.co;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 * 
 * @author sagar.akshayan
 *
 */
public class SimpleProducer {

	private static Producer<Integer, String> producer;

	public SimpleProducer() {
		Properties props = PropertiesLoader.getKafkaProperties();
		producer = new Producer<Integer, String>(new ProducerConfig(props));
	}

	private String populateMessage() {
		StringBuilder sb = new StringBuilder();
		sb.append("Welcome to edureka kafka course" + "\n");
		sb.append("This is an example for publishing a simple message to kafka producer"
				+ "\n");
		sb.append("Consume this message using the kafka consumer console"
				+ "\n");
		return sb.toString();
	}

	private void sendMessage(String topic) {
		try {
			String message = populateMessage();
			KeyedMessage<Integer, String> data = new KeyedMessage<Integer, String>(
					topic, message);
			producer.send(data);
		} catch (Exception e) {
		} finally {
			producer.close();
		}
	}

	//bin/kafka-console-consumer.sh --zookeeper localhost:2181 --topic kafka-topic --from-beginning
	public static void main(String[] args) {
	  System.out.println("Program to publish simple message to Kafka producer");
	  SimpleProducer sp=new SimpleProducer();
	  //This topic will be created if not exists
	  //Remove the topic if already exists from zookeeper
	  System.out.println("Created topic kafka-topic" );
	  sp.sendMessage("kafka-topic");
	  System.out.println("Message sent succesfully");
	  
	}
}
