package com.demo.rest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.demo.dto.Currency;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("devise")
@Produces("application/json")
public class DeviseRest {
	
	private Map<String,Currency> mapCurrency = new HashMap<>();

	public DeviseRest() {
		mapCurrency.put("USD", new Currency("USD" , "Dollar" , 1.0));
		mapCurrency.put("EUR", new Currency("EUR" , "Euro" , 1.1));
		mapCurrency.put("GBP", new Currency("GBP" , "Livre" , 1.2));
		mapCurrency.put("JPY", new Currency("JPY" , "Yen" , 123.4));
	}
	
	//http://localhost:9080/micro-app/my-api/devise
	@GET
	@Path("/")
	public Collection<Currency> allCurrency(){
		return this.mapCurrency.values();
	}
	
	//http://localhost:9080/micro-app/my-api/devise/EUR
	@GET
	@Path("/{code}")
	public Currency getCurrencyByCode(@PathParam("code") String code){
		return this.mapCurrency.get(code);
	}
}
