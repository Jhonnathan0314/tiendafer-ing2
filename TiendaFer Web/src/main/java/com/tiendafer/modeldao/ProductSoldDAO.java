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
import com.tiendafer.interfaces.ProductSoldCRUD;
import com.tiendafer.model.ProductSold;

/**
 * @author Jonatan
 *
 */
public class ProductSoldDAO implements ProductSoldCRUD {

	private ProductSold productSold;
	
	private ProductDAO productDAO;
	private BillDAO billDAO;
	
	private Connection conect = null;

	public ProductSoldDAO() {
		productSold = new ProductSold();
		
		productDAO = new ProductDAO();
		billDAO = new BillDAO();
	}
	
	//Metodos propios
	public boolean createProductSold(ProductSold productSold) {
		String query;
		query = "INSERT INTO PRODUCTO_VENDIDO VALUES(" + productSold.getProduct().getCode() +
				", " + productSold.getBill().getBillNumber() + ", " + productSold.getProductAmount() +
				", " + productSold.getUnitValue() + ", " + productSold.getTotalValue() + ")";
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

	public ArrayList<ProductSold> searchAll() {
		String query;
		query = "SELECT * FROM PRODUCTO_VENDIDO";
		ArrayList<ProductSold> productSolds = new ArrayList<ProductSold>();
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			Statement stmt;
			stmt = conect.createStatement();
			ResultSet record = stmt.executeQuery(query);
			while(record.next()) {
				productSold = new ProductSold();
				productSold.setProduct(productDAO.searchByCode(record.getInt("producto")));
				productSold.setBill(billDAO.searchByCode(record.getInt("factura")));
				productSold.setProductAmount(record.getInt("cantidad_producto"));
				productSold.setUnitValue(record.getInt("valor_unitario"));
				productSold.setTotalValue(record.getInt("valor_total"));
				productSolds.add(productSold);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productSolds;
	}
	
	public ArrayList<ProductSold> searchByBill(int code){
		String query;
		query = "SELECT * FROM PRODUCTO_VENDIDO where factura = " + code;
		ArrayList<ProductSold> productSolds = new ArrayList<ProductSold>();
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			Statement stmt;
			stmt = conect.createStatement();
			ResultSet record = stmt.executeQuery(query);
			while(record.next()) {
				productSold = new ProductSold();
				productSold.setProduct(productDAO.searchByCode(record.getInt("producto")));
				productSold.setBill(billDAO.searchByCode(record.getInt("factura")));
				productSold.setProductAmount(record.getInt("cantidad_producto"));
				productSold.setUnitValue(record.getInt("valor_unitario"));
				productSold.setTotalValue(record.getInt("valor_total"));
				productSolds.add(productSold);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productSolds;
	}
	
	//Metodos get y set
	public Connection getConect() {
		return conect;
	}

	public void setConect(Connection conect) {
		this.conect = conect;
	}
}
