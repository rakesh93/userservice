package com.ilearn.userservice.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ilearn.userservice.model.UserCreatedEvent;

@Service
public class UserKafkaProducer {

	private final KafkaTemplate<String, Object> kafkaTemplate;
	
	public UserKafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
	
	public void sendMessage(String message) {
        kafkaTemplate.send("user-topic", message);
        System.out.println("Message Sent : " + message);
    }
	
	public void publish(UserCreatedEvent event){
        kafkaTemplate.send("user-topic", event);
        System.out.println("Saga Pattern Message Sent : " + event);
    }

}
