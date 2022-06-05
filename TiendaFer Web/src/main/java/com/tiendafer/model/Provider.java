package com.tiendafer.model;

import java.math.BigInteger;

public class Provider {
	//Declaracion de variables
	private BigInteger nit;
	private String supplierName;
	private String sellerName;

	
	
	//Metodo constructor
	public Provider(BigInteger nit, String supplierName, String sellerName) {
		this.nit = nit;
		this.supplierName = supplierName;
		this.sellerName = sellerName;
	}

	public Provider() {

	}

	//Metodos Get y Set
	public BigInteger getNit() {
		return nit;
	}

	public void setNit(BigInteger nit) {
		this.nit = nit;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
}
