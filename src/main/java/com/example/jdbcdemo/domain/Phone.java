package com.example.jdbcdemo.domain;

public class Phone {
	
	private long id;
	private String mark;
	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getVat() {
		return vat;
	}

	public void setVat(int vat) {
		this.vat = vat;
	}
	private double price;
	private String model;
	private int vat;
	
	public Phone() {
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public Phone(String mark, double price, String model, int vat) {
		super();
		this.mark = mark;
		this.price = price;
		this.model = model;
		this.vat = vat;
	}
	
}
