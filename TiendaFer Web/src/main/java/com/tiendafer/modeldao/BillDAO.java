/**
 * 
 */
package com.tiendafer.modeldao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tiendafer.control.Conexion;
import com.tiendafer.interfaces.BillCRUD;
import com.tiendafer.model.Bill;

/**
 * @author Jonatan
 *
 */
public class BillDAO implements BillCRUD {
	
	private Bill bill;
	private ClientDAO clientDAO;
	private Connection conect = null;
	
	public BillDAO() {
		bill = new Bill();
		clientDAO = new ClientDAO();
	}
	
	//Metodos propios
	public boolean createBill(Bill bill) {
		String query;
		query = "INSERT INTO FACTURA VALUES(default, " + bill.getSaleValue() +
				", '" + bill.getDate() + "', " + bill.getClient().getDni() +")";
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			Statement stmt;
			stmt = conect.createStatement();
			stmt.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<Bill> searchAll() {
		String query;
		query = "SELECT * FROM FACTURA";
		ArrayList<Bill> bills = new ArrayList<Bill>();
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			Statement stmt;
			stmt = conect.createStatement();
			ResultSet record = stmt.executeQuery(query);
			while(record.next()) {
				bill = new Bill();
				bill.setBillNumber(record.getInt("codigo"));
				bill.setSaleValue(record.getInt("valor_total"));
				bill.setDate(record.getString("fecha"));
				bill.setClient(clientDAO.searchByDni(record.getInt("cliente")));
				bills.add(bill);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bills;
	}
	
	public int searchLastBill() {
		String query;
		query = "SELECT MAX(codigo) as codigo FROM factura";
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			Statement stmt;
			stmt = conect.createStatement();
			ResultSet record = stmt.executeQuery(query);
			if(record.next()) {
				bill = new Bill();
				bill.setBillNumber(record.getInt("codigo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bill.getBillNumber();
	}
	
	public ArrayList<Bill> searchByClient(int dni) {
		String query;
		query = "SELECT * FROM FACTURA WHERE cliente = " + dni;
		ArrayList<Bill> bills = new ArrayList<Bill>();
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			Statement stmt;
			stmt = conect.createStatement();
			ResultSet record = stmt.executeQuery(query);
			while(record.next()) {
				bill = new Bill();
				bill.setBillNumber(record.getInt("codigo"));
				bill.setSaleValue(record.getInt("valor_total"));
				bill.setDate(record.getString("fecha"));
				bill.setClient(clientDAO.searchByDni(record.getInt("cliente")));
				bills.add(bill);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bills;
	}
	
	public ArrayList<Bill> searchByDate(String date) {
		String query;
		query = "SELECT * FROM FACTURA WHERE fecha = '" + date + "'";
		ArrayList<Bill> bills = new ArrayList<Bill>();
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			Statement stmt;
			stmt = conect.createStatement();
			ResultSet record = stmt.executeQuery(query);
			while(record.next()) {
				bill = new Bill();
				bill.setBillNumber(record.getInt("codigo"));
				bill.setSaleValue(record.getInt("valor_total"));
				bill.setDate(record.getString("fecha"));
				bill.setClient(clientDAO.searchByDni(record.getInt("cliente")));
				bills.add(bill);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bills;
	}
	
	public Bill searchByCode(int code) {
		String query;
		query = "SELECT * FROM FACTURA WHERE codigo = " + code;
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			Statement stmt;
			stmt = conect.createStatement();
			ResultSet record = stmt.executeQuery(query);
			if(record.next()) {
				bill = new Bill();
				bill.setBillNumber(record.getInt("codigo"));
				bill.setSaleValue(record.getInt("valor_total"));
				bill.setDate(record.getString("fecha"));
				bill.setClient(clientDAO.searchByDni(record.getInt("cliente")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bill;
	}
	
	//Metodos get y set
	public Connection getConect() {
		return conect;
	}

	public void setConect(Connection conect) {
		this.conect = conect;
	}
}
