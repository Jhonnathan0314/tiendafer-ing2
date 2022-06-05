package com.tiendafer.model;

import java.util.ArrayList;

public class BillHasPayment {
	//Declaracion de variables
	private int totalOutstandingBalance;
	private int newOutstandingBalance;
	private int balancePaid;
	private int change;
	
	private ArrayList<Payment> payment;
	private ArrayList<Bill> clientBill;
	
	//Metodo constructor
	public BillHasPayment(int totalOutstandingBalance, int newOutstandingBalance, int balancePaid, int change,
			ArrayList<Payment> payment, ArrayList<Bill> clientBill) {
		this.totalOutstandingBalance = totalOutstandingBalance;
		this.newOutstandingBalance = newOutstandingBalance;
		this.balancePaid = balancePaid;
		this.change = change;
		this.payment = payment;
		this.clientBill = clientBill;
	}
	
	public BillHasPayment() {
		
	}

	//Metodos Get y Set
	public int getTotalOutstandingBalance() {
		return totalOutstandingBalance;
	}

	public void setTotalOutstandingBalance(int totalOutstandingBalance) {
		this.totalOutstandingBalance = totalOutstandingBalance;
	}

	public int getNewOutstandingBalance() {
		return newOutstandingBalance;
	}

	public void setNewOutstandingBalance(int newOutstandingBalance) {
		this.newOutstandingBalance = newOutstandingBalance;
	}

	public int getBalancePaid() {
		return balancePaid;
	}

	public void setBalancePaid(int balancePaid) {
		this.balancePaid = balancePaid;
	}

	public int getChange() {
		return change;
	}

	public void setChange(int change) {
		this.change = change;
	}

	public ArrayList<Payment> getPayment() {
		return payment;
	}

	public void setPayment(ArrayList<Payment> payment) {
		this.payment = payment;
	}

	public ArrayList<Bill> getClientBill() {
		return clientBill;
	}

	public void setClientBill(ArrayList<Bill> clientBill) {
		this.clientBill = clientBill;
	}
}
