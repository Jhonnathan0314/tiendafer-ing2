/**
 * 
 */
package com.tiendafer.modeldao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tiendafer.model.Bill;
import com.tiendafer.model.BillHasPayment;
import com.tiendafer.model.Payment;

/**
 * @author Jonatan
 *
 */
public class BillHasPaymentDAO {
	
	private Payment payment;
	private Bill bill;
	private Connection conect = null;
	
	public BillHasPaymentDAO() {
		payment = new Payment();
		bill = new Bill();
	}
	
	//Metodos propios
	

	public Connection getConect() {
		return conect;
	}

	public void setConect(Connection conect) {
		this.conect = conect;
	}
}
