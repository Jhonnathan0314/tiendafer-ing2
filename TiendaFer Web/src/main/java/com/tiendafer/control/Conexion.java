package com.tiendafer.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.tiendafer.modeldao.*;

public class Conexion {
	//Declaracion de variables
	private ProductDAO productDAO;
	private SectionDAO sectionDAO;
	private ClientDAO clientDAO;
	private ProviderDAO providerDAO;
	private OrderDAO orderDAO;
	private OrderDetailDAO orderDetailDAO;
	private BillDAO billDAO;
	private ProductSoldDAO productSoldDAO;
	private PaymentDAO paymentDAO;
	private BillHasPaymentDAO billHasPaymentDAO;

	private Connection conect = null;
	
	public Conexion() {
		productDAO = new ProductDAO();
		sectionDAO = new SectionDAO();
		clientDAO = new ClientDAO();
		providerDAO = new ProviderDAO();
		orderDAO = new OrderDAO();
		orderDetailDAO = new OrderDetailDAO();
		billDAO = new BillDAO();
		productSoldDAO = new ProductSoldDAO();
		paymentDAO = new PaymentDAO();
		billHasPaymentDAO = new BillHasPaymentDAO();
		
		setConect(getConexion());
	}
	
	public Connection getConexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/tienda_fer";
			String user = "jonatan314";
			String password = "1002394864Jonatan";
			conect = DriverManager.getConnection(url, user, password);
		}catch(ClassNotFoundException e) {
			System.out.println("Error --> al cargar el Driver");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("Error --> con la BD");
			e.printStackTrace();
		}

		return conect;
	}

	//METODOS GET Y SET
	public Connection getConect() {
		return conect;
	}

	public void setConect(Connection conect) {
		this.conect = conect;
		billHasPaymentDAO.setConect(conect);
		clientDAO.setConect(conect);
		billDAO.setConect(conect);
		orderDAO.setConect(conect);
		orderDetailDAO.setConect(conect);
		paymentDAO.setConect(conect);
		productDAO.setConect(conect);
		productSoldDAO.setConect(conect);
		providerDAO.setConect(conect);
		sectionDAO.setConect(conect);
	}
}
