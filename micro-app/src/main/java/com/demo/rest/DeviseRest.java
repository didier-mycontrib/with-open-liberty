package com.demo.rest;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.demo.dao.DeviseDao;
import com.demo.dto.Currency;
import com.demo.entity.Devise;
import com.demo.util.DtoConverter;
import com.demo.util.InitDataSet;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("devise")
@Produces("application/json")
public class DeviseRest {
	
	@Inject
	private InitDataSet initDataSet; //just for dev mode
	
	@Inject
	private DeviseDao deviseDao;
	
	//http://localhost:9080/micro-app/my-api/reInit
	@GET
	@Path("/reinit")
	public Collection<Currency> reInit(){
		initDataSet.initDataSet();//dev mode only
		return allCurrency();
	}
	
	//http://localhost:9080/micro-app/my-api/devise
	@GET
	@Path("/")
	public Collection<Currency> allCurrency(){
		List<Devise> deviseList = deviseDao.readAllDevises();
		return deviseList.stream()
				.map( d -> DtoConverter.deviseToCurrency(d) )
				.collect(Collectors.toList());
	}
	
	//http://localhost:9080/micro-app/my-api/devise/EUR
	@GET
	@Path("/{code}")
	public Currency getCurrencyByCode(@PathParam("code") String code){
		return DtoConverter.deviseToCurrency(deviseDao.readDevise(code));
	}
}
