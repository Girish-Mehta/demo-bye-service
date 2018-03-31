package com.example.demo;

import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DemoByeController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	//using messege sender service to send message to rabbitmq
	@Autowired
	private MessageSender sendMessageToRabbit;
	
	
	@HystrixCommand(fallbackMethod="fallback")
	@GetMapping("/bye")
	public String sayBye() {
		logger.info("{}", "hi");
		
		if(RandomUtils.nextBoolean()) {
			throw new RuntimeException("Failed loadin Bye");
		}
		return "bye";
	}
	
	public String fallback() {

		return "Fallback bye";
	}

	//a demo mapping to send msg
	@RequestMapping("/send")
	public String sendMsg(){
		String msg="sending";
		logger.info("Sending message...");
		sendMessageToRabbit.produceMsg(msg);
		return "Done";
	}
		
	//a demo mapping to send msg
	@RequestMapping("/sendd")
	public String sendMsgg(){
		String msg="sendingg";
		logger.info("Sending message...");
		sendMessageToRabbit.produceMsg(msg);
		return "Done";
	}


}
