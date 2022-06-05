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
import com.tiendafer.interfaces.ProviderCRUD;
import com.tiendafer.model.Provider;

/**
 * @author Jonatan
 *
 */
public class ProviderDAO implements ProviderCRUD {

	private Provider provider;
	private Connection conect = null;

	public ProviderDAO() {
		provider = new Provider();
	}

	//Metodos propios
	public boolean createProvider(Provider provider) {
		String query;
		query = "INSERT INTO PROVEEDOR VALUES("+provider.getNit()+", '"+provider.getSupplierName()
		+"'"+", '"+provider.getSellerName()+"'"+")";
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

	public boolean updateSupplierName(BigInteger nit, String supplierName) {
		String query;
		query = "UPDATE PROVEEDOR SET nombre_proveedor = '" + supplierName + "' WHERE nit = " + nit;
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

	public boolean updateSellerName(BigInteger nit, String sellerName) {
		String query;
		query = "UPDATE PROVEEDOR SET nombre_vendedor = '" + sellerName + "' WHERE nit = " + nit;
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
	
	public ArrayList<Provider> searchAll() {
		String query;
		query = "SELECT * FROM PROVEEDOR";
		ArrayList<Provider> providers = new ArrayList<Provider>();
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			Statement stmt;
			stmt = conect.createStatement();
			ResultSet record = stmt.executeQuery(query);
			while(record.next()) {
				provider = new Provider();
				provider.setNit(new BigInteger(record.getString("nit")));
				provider.setSupplierName(record.getString("nombre_proveedor"));
				provider.setSellerName(record.getString("nombre_vendedor"));
				providers.add(provider);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return providers;
	}

	public Provider searchByNit(BigInteger nit) {
		String query;
		query = "SELECT * FROM PROVEEDOR WHERE nit = " + nit;
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			Statement stmt;
			stmt = conect.createStatement();
			ResultSet record = stmt.executeQuery(query);
			provider = new Provider();
			if(record.next()) {
				provider.setNit(new BigInteger(record.getString("nit")));
				provider.setSupplierName(record.getString("nombre_proveedor"));
				provider.setSellerName(record.getString("nombre_vendedor"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return provider;
	}

	public ArrayList<Provider> searchBySupplierName(String supplierName) {
		String query;
		query = "SELECT * FROM PROVEEDOR WHERE nombre_proveedor LIKE '%" + supplierName + "%'";
		ArrayList<Provider> providers = new ArrayList<Provider>();
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			Statement stmt;
			stmt = conect.createStatement();
			ResultSet record = stmt.executeQuery(query);
			while(record.next()) {
				provider = new Provider();
				provider.setNit(new BigInteger(record.getString("nit")));
				provider.setSupplierName(record.getString("nombre_proveedor"));
				provider.setSellerName(record.getString("nombre_vendedor"));
				providers.add(provider);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return providers;
	}

	public ArrayList<Provider> searchBySellerName(String sellerName) {
		String query;
		query = "SELECT * FROM PROVEEDOR WHERE nombre_vendedor LIKE '%" + sellerName + "%'";
		ArrayList<Provider> providers = new ArrayList<Provider>();
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			Statement stmt;
			stmt = conect.createStatement();
			ResultSet record = stmt.executeQuery(query);
			while(record.next()) {
				provider = new Provider();
				provider.setNit(new BigInteger(record.getString("nit")));
				provider.setSupplierName(record.getString("nombre_proveedor"));
				provider.setSellerName(record.getString("nombre_vendedor"));
				providers.add(provider);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return providers;
	}
	
	//Metodos get y set
	public Connection getConect() {
		return conect;
	}

	public void setConect(Connection conect) {
		this.conect = conect;
	}
}
