package com.tiendafer.model;

public class Payment {
	//Declaracion de variables
	private int paymentNumber;
	private String date;
	private int cash;

	private Client client;

	//Metodo constructor
	public Payment(int paymentNumber, String date, int cash, Client client) {
		this.paymentNumber = paymentNumber;
		this.date = date;
		this.cash = cash;
		this.client = client;
	}

	public Payment() {

	}

	//Metodos Get y Set
	public int getPaymentNumber() {
		return paymentNumber;
	}

	public void setPaymentNumber(int paymentNumber) {
		this.paymentNumber = paymentNumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
