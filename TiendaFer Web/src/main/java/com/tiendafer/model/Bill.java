package com.tiendafer.model;

import java.util.ArrayList;
import java.util.List;

public class Bill {
	//Declaracion de variables
	private int billNumber;
	private String date;
	private int saleValue;

	private Client client;

	private List<ProductSold> productSold;
	
	//Metodo constructor
	public Bill(int billNumber, String date, int saleValue, Client client) {
		this.billNumber = billNumber;
		this.date = date;
		this.saleValue = saleValue;
		this.client = client;
	}

	public Bill() {
		productSold = new ArrayList<ProductSold>();
	}

	//Metodos propios
	public void addProductSold(ProductSold productSold) {
		if(this.productSold == null){
            this.productSold = new ArrayList<>();
        }
        
        this.productSold.add(productSold);
	}
	
	public void removeProductSold(int codigo_producto) {
		for(int i=0; i<this.productSold.size(); i++) {
			if(productSold.get(i).getProduct().getCode() == codigo_producto) {
				productSold.remove(i);
			}
		}
	}
	
	public int calculateTotal() {
		int result = 0;
		for(int i=0; i<productSold.size(); i++) {
			result += productSold.get(i).getTotalValue();
		}
		return result;
	}

	public void updateQuantity(int newQuantity, Long productCode) {
		for(int i=0; i<this.productSold.size(); i++) {
			if(productSold.get(i).getProduct().getCode() == productCode) {
				productSold.get(i).setProductAmount(newQuantity);
			}
		}
	}
	
	//Metodos Get y Set
	public int getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(int billNumber) {
		this.billNumber = billNumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getSaleValue() {
		return saleValue;
	}

	public void setSaleValue(int saleValue) {
		this.saleValue = saleValue;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<ProductSold> getProductSold() {
		return productSold;
	}

	public void setProductSold(ArrayList<ProductSold> productSold) {
		this.productSold = productSold;
	}
}
