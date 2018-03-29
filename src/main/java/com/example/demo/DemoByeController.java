package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import brave.sampler.Sampler;

@RestController
public class DemoByeController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Bean
    public Sampler defaultSampler(){
        return Sampler.ALWAYS_SAMPLE;
}

	@GetMapping("/bye")
	public String sayBye() {
		logger.info("{}", "hi");
		return "bye";
	}
	
}
