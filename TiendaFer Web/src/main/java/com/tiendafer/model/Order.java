package com.tiendafer.model;

import java.util.ArrayList;

public class Order {
	//Declaracion de variables
	private int orderCode;
	private String date;
	private int totalValue;
	
	private Provider provider;
	
	private ArrayList<OrderDetail> orderDetail = new ArrayList<OrderDetail>();
	
	//Metodo constructor
	public Order(int orderCode, String date, int totalValue, ArrayList<OrderDetail> orderDetail) {
		this.orderCode = orderCode;
		this.date = date;
		this.totalValue = totalValue;
		this.orderDetail = orderDetail;
	}
	
	public Order() {
		
	}
	
	public void addProvider(Provider provider) {
		this.provider = provider;
	}
	
	//Metodos Get y Set
	public int getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public int getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public ArrayList<OrderDetail> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(ArrayList<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}
}
