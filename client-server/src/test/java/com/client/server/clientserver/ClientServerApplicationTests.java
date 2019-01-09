package com.client.server.clientserver;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;
import java.time.LocalTime;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServerApplicationTests {

	
	@Autowired
	private ApiService apiService;
	
	
	@Test
	public void contextLoads() {
		 String responseobj = "{\"minutes\":\"6\",\"platform\":\"2\",\"direction\":\"North\",\"length\":\"10\",\"color\":\"YELLOW\",\"hexcolor\":\"#ffff33\",\"bikeflag\":\"1\",\"delay\":\"73\"}";
		 String responsearr = 	"[{\"minutes\":\"6\",\"platform\":\"2\",\"direction\":\"North\",\"length\":\"10\",\"color\":\"YELLOW\",\"hexcolor\":\"#ffff33\",\"bikeflag\":\"1\",\"delay\":\"73\"},{\"minutes\":\"20\",\"platform\":\"2\",\"direction\":\"North\",\"length\":\"10\",\"color\":\"YELLOW\",\"hexcolor\":\"#ffff33\",\"bikeflag\":\"1\",\"delay\":\"0\"},{\"minutes\":\"35\",\"platform\":\"2\",\"direction\":\"North\",\"length\":\"10\",\"color\":\"YELLOW\",\"hexcolor\":\"#ffff33\",\"bikeflag\":\"1\",\"delay\":\"0\"}]";
		   
		ResponseEntity<String> rentity = apiService.retrunresponseJson();
		
		JsonReader jsonReader = Json.createReader(new StringReader(rentity.getBody().toString()));
		JsonObject jobj = jsonReader.readObject();  
		 String version = jobj.getJsonObject("?xml").getString("@version");
		 LocalTime r = LocalTime.parse(jobj.getJsonObject("root").getString("time").split(" ")[0]);
		 JsonArray etd = jobj.getJsonObject("root").getJsonArray("station").getJsonObject(0).getJsonArray("etd");
		 String destination = etd.getJsonObject(0).getString("destination");
		 JsonArray estimate = etd.getJsonObject(0).getJsonArray("estimate"); 
		 assertEquals("North", estimate.getJsonObject(0).getString("direction"));
		 //assertEquals("6", minutes);
		
	}

}

