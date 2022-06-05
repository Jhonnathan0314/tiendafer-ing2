/**
 * 
 */
package com.tiendafer.modeldao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tiendafer.control.Conexion;
import com.tiendafer.interfaces.OrderCRUD;
import com.tiendafer.model.Order;

/**
 * @author Jonatan
 *
 */
public class OrderDAO implements OrderCRUD {

	private Order order;
	private ProviderDAO providerDAO;
	private Connection conect = null;

	public OrderDAO() {
		order = new Order();
		providerDAO = new ProviderDAO();
	}
	
	//Metodos propios
	@Override
	public boolean createOrder(Order order) {
		String query;
		query = "INSERT INTO PEDIDO VALUES(default, '" + order.getDate() +
				"', " + order.getTotalValue() + ", " + order.getProvider().getNit() +")";
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

	@Override
	public ArrayList<Order> searchAll() {
		String query;
		query = "SELECT * FROM PEDIDO";
		ArrayList<Order> orders = new ArrayList<Order>();
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			Statement stmt;
			stmt = conect.createStatement();
			ResultSet record = stmt.executeQuery(query);
			while(record.next()) {
				order = new Order();
				order.setOrderCode(record.getInt("codigo"));
				order.setDate(record.getString("fecha"));
				order.setTotalValue(record.getInt("valor_total"));
				order.setProvider(providerDAO.searchByNit(new BigInteger(record.getString("proveedor"))));
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public int searchLastOrder() {
		String query;
		query = "SELECT MAX(codigo) as codigo FROM pedido";
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			Statement stmt;
			stmt = conect.createStatement();
			ResultSet record = stmt.executeQuery(query);
			if(record.next()) {
				order = new Order();
				order.setOrderCode(record.getInt("codigo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order.getOrderCode();
	}

	@Override
	public ArrayList<Order> searchByProvider(String nit) {
		String query;
		query = "SELECT * FROM PEDIDO WHERE proveedor = " + nit;
		ArrayList<Order> orders = new ArrayList<Order>();
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			Statement stmt;
			stmt = conect.createStatement();
			ResultSet record = stmt.executeQuery(query);
			while(record.next()) {
				order = new Order();
				order.setOrderCode(record.getInt("codigo"));
				order.setDate(record.getString("fecha"));
				order.setTotalValue(record.getInt("valor_total"));
				order.setProvider(providerDAO.searchByNit(new BigInteger(record.getString("proveedor"))));
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public Order searchByCode(int code) {
		String query;
		query = "SELECT * FROM PEDIDO WHERE codigo = " + code;
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			Statement stmt;
			stmt = conect.createStatement();
			ResultSet record = stmt.executeQuery(query);
			if(record.next()) {
				order = new Order();
				order.setOrderCode(record.getInt("codigo"));
				order.setDate(record.getString("fecha"));
				order.setTotalValue(record.getInt("valor_total"));
				order.setProvider(providerDAO.searchByNit(new BigInteger(record.getString("proveedor"))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}

	public ArrayList<Order> searchByDate(String date) {
		String query;
		query = "SELECT * FROM PEDIDO WHERE fecha = '" + date + "'";
		ArrayList<Order> orders = new ArrayList<Order>();
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			Statement stmt;
			stmt = conect.createStatement();
			ResultSet record = stmt.executeQuery(query);
			while(record.next()) {
				order = new Order();
				order.setOrderCode(record.getInt("codigo"));
				order.setTotalValue(record.getInt("valor_total"));
				order.setDate(record.getString("fecha"));
				order.setProvider(providerDAO.searchByNit(new BigInteger(record.getString("proveedor"))));
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}

	public Connection getConect() {
		return conect;
	}

	public void setConect(Connection conect) {
		this.conect = conect;
	}

}
