package com.demo.util;

import com.demo.dao.DeviseDao;
import com.demo.entity.Devise;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
public class InitDataSet {
	
	@Inject
	private DeviseDao deviseDao;
	
	public void initDataSet() {
		deviseDao.deleteAllDevise();
		deviseDao.createDevise( new Devise("USD" , "Dollar" , 1.0));
		deviseDao.createDevise( new Devise("EUR" , "Euro" , 1.1));
		deviseDao.createDevise( new Devise("GBP" , "Livre" , 1.2));
		deviseDao.createDevise( new Devise("JPY" , "Yen" , 123.4));
	}

}
