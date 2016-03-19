package com.edureka.co;

import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;

public class KafkaPartitioner implements Partitioner {

	public KafkaPartitioner(VerifiableProperties props) {

	}

	public int partition(Object key, int numPartitions) {
		int partition = 0;
		System.out.println("key" + key);
		if (key instanceof String) {
			int iKey = Integer.parseInt((String) key);
			if (iKey > 0) {
				partition = iKey % numPartitions;
			}
		}
		return partition;

	}

}
