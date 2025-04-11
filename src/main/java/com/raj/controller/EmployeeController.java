package com.raj.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class EmployeeController {
  
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    RestTemplate restTemplate;
    
    @Autowired
    Environment env;
 
    @RequestMapping(value= "/add", method = RequestMethod.POST,consumes = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addEmployee(@RequestBody String empjson) throws URISyntaxException {    	
        logger.debug("adding employees and loggin.");
        RequestEntity request = RequestEntity
        	     .post(new URI(env.getRequiredProperty("emp.create.url"))).contentType(MediaType.APPLICATION_JSON)
        	     .body(empjson);
        ResponseEntity<String> response = restTemplate.exchange(request, String.class);
        return response;
    }
}