package com.client.server.clientserver;

import java.io.StringReader;
import java.time.LocalTime;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

	@Autowired
	private RestTemplate restTemplate;
	
	public ResponseEntity<String> retrunresponseJson(){
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String AccessToken ="22dn23f8b29qbfsdfn934bgon2q039fnqn24fncq9348tgvnf92q84fcn2948tfh02	";
		headers.set("Authorization", "Bearer "+AccessToken);
		

		HttpEntity<String> entity = new HttpEntity<String>("requestJson",headers);
		//String result = restTemplate.postForObject(url, entity, String.class);
		//JSONHelper jhelper = new JSONHelper();
		//ArrayList<String> als = restTemplate.getForObject("http://localhost:3000/hello/list",ArrayList.class);
		
		//ResponseEntity<String> res = restTemplate.exchange("http://localhost:3000/hello/list",HttpMethod.GET,entity,String.class);
		
		ResponseEntity<String> res = restTemplate.exchange("http://api.bart.gov/api/etd.aspx?cmd=etd&orig=MONT&key=MW9S-E7SL-26DU-VV8V&json=y",HttpMethod.GET,entity,String.class);
		System.out.println("inside the /clientlist");
		System.out.println(res.getStatusCodeValue());
		
		//String str = res.getBody();
		
		JsonReader jsonReader = Json.createReader(new StringReader(res.getBody().toString()));
		System.out.println("before");
		JsonObject jobj = jsonReader.readObject();  
		System.out.println("after");
		 String version = jobj.getJsonObject("?xml").getString("@version");
		 LocalTime r = LocalTime.parse(jobj.getJsonObject("root").getString("time").split(" ")[0]);
		 JsonArray etd = jobj.getJsonObject("root").getJsonArray("station").getJsonObject(0).getJsonArray("etd");
		 String destination = etd.getJsonObject(0).getString("destination");
		 JsonArray estimate = etd.getJsonObject(0).getJsonArray("estimate"); 
		//System.out.println(res.getBody().isEmpty());
		return res;
	}
	
	
	
}
