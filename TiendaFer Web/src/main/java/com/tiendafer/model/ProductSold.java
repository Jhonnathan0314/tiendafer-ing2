package com.tiendafer.model;

public class ProductSold {
	//Declaracion de variables
	private Bill bill;
	private int productAmount;
	private int unitValue;
	private int totalValue;

	private Product product;

	//Metodo constructor
	public ProductSold(Bill bill, int productAmount, int unitValue, int totalValue, Product product) {
		this.bill = bill;
		this.productAmount = productAmount;
		this.unitValue = unitValue;
		this.totalValue = totalValue;
		this.product = product;
	}

	public ProductSold() {
		bill = new Bill();
		product = new Product();
	}

	//Metodos Get y Set
	public int getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
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

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}
}
