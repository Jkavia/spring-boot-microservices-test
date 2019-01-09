package com.client.server.clientserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

@RestController
public class ClientController {

	@Autowired
	private ApiService apiService;
	

	
	@RequestMapping(value="/clientlist", method=RequestMethod.GET)
	public ResponseEntity<String> gettheList(RestTemplate restTemplate) throws JsonProcessingException, IOException{
		return apiService.retrunresponseJson();	
	}
	
	
	@RequestMapping(value="/error", method=RequestMethod.GET)
	public String errorMessange() {
		return "500 Internal Server Error!";
	}
	
}


