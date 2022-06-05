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
import com.tiendafer.interfaces.ProductCRUD;
import com.tiendafer.model.Product;
import com.tiendafer.model.Section;

/**
 * @author Jonatan
 *
 */
public class ProductDAO implements ProductCRUD {

	private Product product;
	private SectionDAO sectionDAO;
	private Connection conect = null;

	public ProductDAO() {
		product = new Product();
		sectionDAO = new SectionDAO();
	}

	//Metodos Propios
	public boolean createProduct(Product product) {
		String query;
		if(product.getSection().getCode() != 0) {
			query = "INSERT INTO PRODUCTO VALUES(default, '"+product.getName()+"'"+
					", "+product.getValue()+", '"+product.getChange()+"', "+
					product.getSection().getCode()+", "+product.getQuantityAvailable()+")";
		}else {
			query = "INSERT INTO PRODUCTO VALUES(default, '"+product.getName()+"'"+
					", "+product.getValue()+", '"+product.getChange()+"', default, "
					+product.getQuantityAvailable()+")";
		}
		Statement stmt;
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			stmt = conect.createStatement();
			stmt.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateName(int code, String newName) {
		String query;
		query = "UPDATE PRODUCTO SET nombre = '" + newName + "' WHERE codigo = " + code;
		Statement stmt;
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			stmt = conect.createStatement();
			stmt.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateValue(int code, int newValue) {
		String query;
		query = "UPDATE PRODUCTO SET valor_venta = '" + newValue + "' WHERE codigo = " + code;
		Statement stmt;
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			stmt = conect.createStatement();
			stmt.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateChange(int code, String newChange) {
		String query;
		query = "UPDATE PRODUCTO SET posibilidad_cambio = '" + newChange + "' WHERE codigo = " + code;
		Statement stmt;
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			stmt = conect.createStatement();
			stmt.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateQuantity(int code, int newQuantity) {
		String query;
		query = "UPDATE PRODUCTO SET cantidad_disponible = '" + newQuantity + "' WHERE codigo = " + code;
		Statement stmt;
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			stmt = conect.createStatement();
			stmt.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Product> searchAll() {
		String query;
		query = "SELECT * FROM PRODUCTO";

		ArrayList<Product> result = new ArrayList<Product>();
		Statement stmt;
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			stmt = conect.createStatement();
			ResultSet record = stmt.executeQuery(query);
			while(record.next()) {
				product = new Product();
				product.setCode(Integer.parseInt(record.getString("codigo")));
				product.setName(record.getString("nombre"));
				product.setValue(Integer.parseInt(record.getString("valor_venta")));
				product.setChange(record.getString("posibilidad_cambio"));
				product.setQuantityAvailable(Integer.parseInt(record.getString("cantidad_disponible")));
				Section section = new Section();
				try {
					section = sectionDAO.searchByCode(record.getInt("seccion"));
				} catch (Exception e) {
					section = null;
				}
				product.addSection(section);
				result.add(product);
			}
		} catch (SQLException e) {
			System.out.println("Error al consultar: SQLException");
			e.printStackTrace();
		}
		return result;
	}

	public Product searchByCode(int code) {
		String query;
		query = "SELECT * FROM PRODUCTO WHERE codigo = " + code;
		Statement stmt;
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			stmt = conect.createStatement();
			ResultSet record = stmt.executeQuery(query);
			if(record.next()) {
				product = new Product();
				product.setCode(Integer.parseInt(record.getString("codigo")));
				product.setName(record.getString("nombre"));
				product.setValue(Integer.parseInt(record.getString("valor_venta")));
				product.setChange(record.getString("posibilidad_cambio"));
				product.setQuantityAvailable(Integer.parseInt(record.getString("cantidad_disponible")));
				Section section = new Section();
				try {
					section = sectionDAO.searchByCode(record.getInt("seccion"));
				} catch (Exception e) {
					section = null;
				}
				product.addSection(section);
			}
		} catch (SQLException e) {
			System.out.println("Error al consultar: SQLException");
			e.printStackTrace();
		}
		return product;
	}

	public ArrayList<Product> searchByName(String name) {
		String query;
		query = "SELECT * FROM PRODUCTO WHERE nombre LIKE '%"+ name + "%'";
		System.out.println(query);
		
		ArrayList<Product> products = new ArrayList<Product>();
		
		Statement stmt;
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			stmt = conect.createStatement();
			ResultSet record = stmt.executeQuery(query);
			while(record.next()) {
				product = new Product();
				product.setCode(Integer.parseInt(record.getString("codigo")));
				product.setName(record.getString("nombre"));
				product.setValue(Integer.parseInt(record.getString("valor_venta")));
				product.setChange(record.getString("posibilidad_cambio"));
				product.setQuantityAvailable(Integer.parseInt(record.getString("cantidad_disponible")));
				Section section = new Section();
				try {
					section = sectionDAO.searchByCode(record.getInt("seccion"));
				} catch (Exception e) {
					section = null;
				}
				product.addSection(section);
				products.add(product);
			}
		} catch (SQLException e) {
			System.out.println("Error al consultar: SQLException");
			e.printStackTrace();
		}
		return products;
	}
	
	public ArrayList<Product> searchByValue(int value) {
		String query;
		query = "SELECT * FROM PRODUCTO WHERE valor_venta = "+ value;

		ArrayList<Product> products = new ArrayList<Product>();
		
		Statement stmt;
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			stmt = conect.createStatement();
			ResultSet record = stmt.executeQuery(query);
			while(record.next()) {
				product = new Product();
				product.setCode(Integer.parseInt(record.getString("codigo")));
				product.setName(record.getString("nombre"));
				product.setValue(Integer.parseInt(record.getString("valor_venta")));
				product.setChange(record.getString("posibilidad_cambio"));
				product.setQuantityAvailable(Integer.parseInt(record.getString("cantidad_disponible")));
				Section section = new Section();
				try {
					section = sectionDAO.searchByCode(record.getInt("seccion"));
				} catch (Exception e) {
					section = null;
				}
				product.addSection(section);
				products.add(product);
			}
		} catch (SQLException e) {
			System.out.println("Error al consultar: SQLException");
			e.printStackTrace();
		}
		return products;
	}

	public ArrayList<Product> searchScarceProducts() {
		String query;

		query = "SELECT * FROM PRODUCTO WHERE cantidad_disponible <= 2";

		ArrayList<Product> result = new ArrayList<Product>();
		Statement stmt;
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			stmt = conect.createStatement();
			ResultSet record = stmt.executeQuery(query);
			while(record.next()) {
				product = new Product();
				product.setCode(Integer.parseInt(record.getString("codigo")));
				product.setName(record.getString("nombre"));
				product.setValue(Integer.parseInt(record.getString("valor_venta")));
				product.setChange(record.getString("posibilidad_cambio"));
				product.setQuantityAvailable(Integer.parseInt(record.getString("cantidad_disponible")));
				Section section = new Section();
				try {
					section = sectionDAO.searchByCode(record.getInt("seccion"));
				} catch (Exception e) {

				}
				product.addSection(section);
				result.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al consultar: SQLException");
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<Product> searchProductsBySection(String sectionCode) {
		String query;

		query = "SELECT * FROM PRODUCTO WHERE seccion = " + sectionCode;

		ArrayList<Product> result = new ArrayList<Product>();
		Statement stmt;
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			stmt = conect.createStatement();
			ResultSet record = stmt.executeQuery(query);
			Section section;
			while(record.next()) {
				section = new Section();
				product = new Product();
				product.setCode(record.getInt("codigo"));
				product.setName(record.getString("nombre"));
				product.setValue(record.getInt("valor_venta"));
				product.setChange(record.getString("posibilidad_cambio"));
				product.setQuantityAvailable(record.getInt("cantidad_disponible"));
				section = sectionDAO.searchByCode(record.getInt("seccion"));
				product.addSection(section);
				result.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al consultar: SQLException");
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
