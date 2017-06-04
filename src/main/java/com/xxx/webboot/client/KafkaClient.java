package com.xxx.webboot.client;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaClient {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@KafkaListener(topics = "myTopic")
    public void processMessage(String content) {
		
		System.out.println("content: "+ content);
		String topic = kafkaTemplate.getDefaultTopic();
		System.out.println("topic: "+ topic);
    }
	
	
	public void sendMessage2KafkaTopic(){
		kafkaTemplate.send("myTopic", "test");
		kafkaTemplate.metrics();
		kafkaTemplate.setProducerListener(new ProducerListener<String, String>() {
			
			@Override
			public void onSuccess(String topic, Integer partition, String key, String value, RecordMetadata recordMetadata) {
				
				System.out.println("Topic: " + topic + "send Successly!");
			}
			
			@Override
			public void onError(String topic, Integer partition, String key, String value, Exception exception) {
				System.out.println("Topic: " + topic + "send failed!");
			}
			
			@Override
			public boolean isInterestedInSuccess() {
				return false;
			}
		});
	}

}
