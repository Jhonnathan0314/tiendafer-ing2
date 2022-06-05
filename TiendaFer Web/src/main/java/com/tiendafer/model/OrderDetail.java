package com.tiendafer.model;

public class OrderDetail {
	//Declaracion de variables
	private Order order;
	private int orderedAmount;
	private int receivedAmount;
	private int unitValue;
	private int totalValue;

	private Product product;

	//Metodo constructor
	public OrderDetail(Order order, int orderedAmount, int receivedAmount, int unitValue, int totalValue, Product product) {
		this.order = order;
		this.orderedAmount = orderedAmount;
		this.receivedAmount = receivedAmount;
		this.unitValue = unitValue;
		this.totalValue = totalValue;
		this.product = product;
	}

	public OrderDetail() {

	}

	//Metodos Get y Set
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}

	public int getOrderedAmount() {
		return orderedAmount;
	}

	public void setOrderedAmount(int orderedAmount) {
		this.orderedAmount = orderedAmount;
	}

	public int getReceivedAmount() {
		return receivedAmount;
	}

	public void setReceivedAmount(int receivedAmount) {
		this.receivedAmount = receivedAmount;
	}

	public int getUnitValue() {
		return unitValue;
	}

	public void setUnitValue(int unitValue) {
		this.unitValue = unitValue;
	}

	public int getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
