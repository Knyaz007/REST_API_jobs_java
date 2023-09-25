package com.example.demo;

//import com.example.demo.controllers.Controler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Demo1ApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testCalculateFrequency() {
		String input = "aaaaabcccc";
		String url = "http://localhost:" + "8080" +  "/calculate-frequency";

		String response = this.restTemplate.postForObject(url + "?input={input}", null, String.class, input);

		String expectedResponse = "{\"a\":5,\"b\":1,\"c\":4}";



		assertEquals(expectedResponse, response);
	}
}
