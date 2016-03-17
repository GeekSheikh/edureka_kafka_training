package com.edureka.co.util;

import kafka.consumer.ConsumerConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author sagar.akshayan
 *
 */
public class PropertiesLoader {
	

	public static Properties getKafkaProperties(String groupId){
		Properties props = new Properties();
        try {
            props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("kafka.properties"));
            props.setProperty("group.id",groupId);
        } catch (IOException e) {
          e.printStackTrace();
        }
        return props;
	}

	
}
