package com.client.server.clientserver;

import java.util.*;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class ClientServerApplication {

	private static final Logger log=(Logger) LoggerFactory.getLogger(ClientServerApplication.class);
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	public static void main(String[] args) {
		SpringApplication.run(ClientServerApplication.class, args);
	}
//	
//	@Bean
//	public RestTemplate restTemplate(RestTemplateBuilder builder) {
//		return builder.build();
//	}
//	
//	
//	@Bean 
//	public CommandLineRunner run(RestTemplate restTemplate) throws Exception{
//		return (args)->{
//			String str = restTemplate.getForObject("http://localhost:3000/hello/list", String.class);
//			log.info(str);
//		};
//	}

}

