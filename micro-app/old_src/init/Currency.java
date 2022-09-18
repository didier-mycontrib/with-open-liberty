package com.demo.dto;

public class Currency {
	private String code;
	private String name;
	private Double change; //... for one Dollar
	
	public Currency() {
		super();
	}
	public Currency(String code, String name, Double change) {
		super();
		this.code = code;
		this.name = name;
		this.change = change;
	}
	@Override
	public String toString() {
		return "Currency [code=" + code + ", name=" + name + ", change=" + change + "]";
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
