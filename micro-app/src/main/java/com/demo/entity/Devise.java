package com.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "devise")
@NamedQuery(name = "Devise.findAll", query = "SELECT d FROM Devise d")
@NamedQuery(name = "Devise.deleteAll", query = "DELETE FROM Devise")
public class Devise {
	
	@Id
	private String code;
	private String name;
	private Double change; //... for one Dollar
	
	public Devise() {
		super();
	}
	public Devise(String code, String name, Double change) {
		super();
		this.code = code;
		this.name = name;
		this.change = change;
	}
	@Override
	public String toString() {
		return "Devise [code=" + code + ", name=" + name + ", change=" + change + "]";
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getChange() {
		return change;
	}
	public void setChange(Double change) {
		this.change = change;
	}
	
	
	
}
