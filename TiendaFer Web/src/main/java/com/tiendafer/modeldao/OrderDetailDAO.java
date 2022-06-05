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
import com.tiendafer.interfaces.OrderDetailCRUD;
import com.tiendafer.model.OrderDetail;

/**
 * @author Jonatan
 *
 */
public class OrderDetailDAO implements OrderDetailCRUD {

	private OrderDetail orderDetail;
	
	private ProductDAO productDAO;
	private OrderDAO orderDAO;
	
	private Connection conect = null;

	public OrderDetailDAO() {
		orderDetail = new OrderDetail();
		
		productDAO = new ProductDAO();
		orderDAO = new OrderDAO();
	}
	
	//Metodos propios
	@Override
	public boolean createOrderDetail(OrderDetail orderDetail) {
		String query;
		query = "INSERT INTO DETALLE_PEDIDO VALUES(" + orderDetail.getProduct().getCode() +
				", " + orderDetail.getOrder().getOrderCode() + ", " + orderDetail.getOrderedAmount() +
				", " + orderDetail.getReceivedAmount() + ", " + orderDetail.getUnitValue() +
				", " + orderDetail.getTotalValue() + ")";
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
	public ArrayList<OrderDetail> searchAll() {
		String query;
		query = "SELECT * FROM DETALLE_PEDIDO";
		ArrayList<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			Statement stmt;
			stmt = conect.createStatement();
			ResultSet record = stmt.executeQuery(query);
			while(record.next()) {
				orderDetail = new OrderDetail();
				orderDetail.setProduct(productDAO.searchByCode(record.getInt("producto")));
				orderDetail.setOrder(orderDAO.searchByCode(record.getInt("pedido")));
				orderDetail.setOrderedAmount(record.getInt("cantidad_pedida"));
				orderDetail.setReceivedAmount(record.getInt("cantidad_recibida"));
				orderDetail.setUnitValue(record.getInt("valor_unitario"));
				orderDetail.setTotalValue(record.getInt("valor_total"));
				orderDetails.add(orderDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderDetails;
	}

	@Override
	public ArrayList<OrderDetail> searchByOrder(int code) {
		String query;
		query = "SELECT * FROM DETALLE_PEDIDO where pedido = " + code;
		ArrayList<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			Statement stmt;
			stmt = conect.createStatement();
			ResultSet record = stmt.executeQuery(query);
			while(record.next()) {
				orderDetail = new OrderDetail();
				orderDetail.setProduct(productDAO.searchByCode(record.getInt("producto")));
				orderDetail.setOrder(orderDAO.searchByCode(record.getInt("pedido")));
				orderDetail.setOrderedAmount(record.getInt("cantidad_pedida"));
				orderDetail.setReceivedAmount(record.getInt("cantidad_recibida"));
				orderDetail.setUnitValue(record.getInt("valor_unitario"));
				orderDetail.setTotalValue(record.getInt("valor_total"));
				orderDetails.add(orderDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderDetails;
	}

	public Connection getConect() {
		return conect;
	}

	public void setConect(Connection conect) {
		this.conect = conect;
	}
}
