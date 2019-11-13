package com.raj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
//@RibbonClient(name = "mongorepo")
public class SpringBootStandAloneApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStandAloneApp.class, args);
	}
	
    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
    	return new RestTemplate();
    }
}
