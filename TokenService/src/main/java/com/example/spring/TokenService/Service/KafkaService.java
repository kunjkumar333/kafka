package com.example.spring.TokenService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaService {
	@Autowired
	public KafkaTemplate<String, String> kafkaTemp;
	
	String KafkaTopic="Token_micro";
	
	public void send(String message) {
		kafkaTemp.send(KafkaTopic,message);
	}
	
	public void sendMessage(String message) {
        
	    ListenableFuture<SendResult<String, String>> future = 
	      kafkaTemp.send(KafkaTopic, message);
		
	    future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

	      
	        public void onSuccess(SendResult<String, String> result) {
	            System.out.println("Sent message=[" + message + 
	              "] with offset=[" + result.getRecordMetadata().offset() + "]");
	        }
	      
	        public void onFailure(Throwable ex) {
	            System.out.println("Unable to send message=[" 
	              + message + "] due to : " + ex.getMessage());
	        }
	    });
	}
}
