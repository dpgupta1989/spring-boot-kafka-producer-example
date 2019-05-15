package com.example.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class Sender {

	@Autowired
	private KafkaTemplate<String, UserModel> kafkaTemplate;
//	private KafkaTemplate<String, String> kafkaTemplate;

	
	private static final String TOPIC = "jsonTopic";
	
	@GetMapping("/publish/{name}")
	public String post(@PathVariable("name") final String name){
		
		kafkaTemplate.send(TOPIC, new UserModel(name, 12000L, "Technology"));
//		kafkaTemplate.send(TOPIC, name);
		System.out.println("@@@@@@@@ Publish Sucessfully");
		return "Publish Sucessfully";
	}
}
