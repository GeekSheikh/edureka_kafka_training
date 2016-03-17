package com.edureka.co;

import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 
 * @author sagar.akshayan
 *
 */
public class PropertiesLoader {
	

	private static ResourceBundle resourceBundle;
	
	static{
		resourceBundle=ResourceBundle.getBundle("kafka");
	}
	
	public static Properties getKafkaProperties(){
		Properties props = new Properties();
		props.put("metadata.broker.list", resourceBundle.getString("metadata.broker.list"));
		props.put("serializer.class", resourceBundle.getString("serializer.class"));
		props.put("request.required.acks", resourceBundle.getString("request.required.acks"));
		return props;
	}

	
}
