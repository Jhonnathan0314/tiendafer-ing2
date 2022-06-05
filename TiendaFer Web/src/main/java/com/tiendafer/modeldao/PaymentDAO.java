/**
 * 
 */
package com.tiendafer.modeldao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tiendafer.interfaces.PaymentCRUD;
import com.tiendafer.model.Client;
import com.tiendafer.model.Payment;

/**
 * @author Jonatan
 *
 */
public class PaymentDAO implements PaymentCRUD {

	private Payment payment;
	private Connection conect = null;

	public PaymentDAO() {
		payment = new Payment();
	}
	
	//Metodos propios
	public ArrayList<Payment> consultPayment(String paymentNumber) {
		// TODO Auto-generated method stub
		String query;

		query = "SELECT * FROM PAGO WHERE numero_pago = " + paymentNumber;			

		return searchPayment(query);
	}

	private ArrayList<Payment> searchPayment(String query) {
		// TODO Auto-generated method stub
		ArrayList<Payment> result = new ArrayList<Payment>();

		Statement stmt;
		try {
			stmt = conect.createStatement();
			ResultSet record = stmt.executeQuery(query);
			while(record.next()) {
				payment = new Payment();
				payment.setPaymentNumber(Integer.parseInt(record.getString("numero_pago")));
				payment.setCash(Integer.parseInt(record.getString("efectivo")));
				payment.setDate(record.getString("fecha"));
				Client client = new Client();
				client.setDni(Integer.parseInt(record.getString("cedula_cliente")));

				result.add(payment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al consultar");
			e.printStackTrace();
		}
		return result;
	}

	public Connection getConect() {
		return conect;
	}

	public void setConect(Connection conect) {
		this.conect = conect;
	}
}
