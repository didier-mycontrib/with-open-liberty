package com.demo.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.demo.dto.Currency;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

/*
 Cette classe de test (en mode IT: Integration Test)
 nécessite (dans pom.xml) des dépendances de ce type:
 org.junit.jupiter/junit-jupiter/5.8.2 (scope=test)
 org.jboss.resteasy/resteasy-client/6.0.0.Final (scope=test)
 org.jboss.resteasy/resteasy-json-binding-provider/6.0.0.Final (scope=test)
 =======
 Si openLiberty a eté lancé en mode dev (via mvn liberty:dev)
 on peut alors lancer ce(s) test(s) en appuyant sur "enter" dans 
 console/terminal .
 */


public class DeviseEndpointIT {
	
	private static final Jsonb JSONB = JsonbBuilder.create();
	
	@Test
	public void testGetEURCurrency() {
	    	/*
	        String port = System.getProperty("http.port");
	        String context = System.getProperty("context.root");
	        String url = "http://localhost:" + port + "/" + context + "/";
	        */
	    	String url = "http://localhost:" + 9080 + "/" + "micro-app" + "/";

	        Client client = ClientBuilder.newClient();

	        WebTarget target = client.target(url + "my-api/devise/EUR");
	        Response response = target.request().get();

	        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus(),
	                     "Incorrect response code from " + url);

	        String json = response.readEntity(String.class);
	        System.out.println("json response = " + json);
	        
	        Currency eurCurrency = JSONB.fromJson(json, Currency.class);
	        System.out.println("eurCurrency = " + eurCurrency);
	        assertEquals(eurCurrency.getCode(), "EUR","code of Euro must be EUR");
	        
	        response.close();
	        client.close();
	    }
}
