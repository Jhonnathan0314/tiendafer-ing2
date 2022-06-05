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
import com.tiendafer.interfaces.ClientCRUD;
import com.tiendafer.model.Client;

/**
 * @author Jonatan
 *
 */
public class ClientDAO implements ClientCRUD {

	private Client client;
	private Connection conect = null;

	public ClientDAO() {
		client = new Client();
	}

	//Metodos propios
	public boolean createClient(Client client) {
		String query;
		query = "INSERT INTO CLIENTE VALUES("+client.getDni()+", '"+client.getName()+"'"+")";
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

	public boolean updateName(int dni, String newName) {
		String query;
		query = "UPDATE CLIENTE SET nombre = '" + newName + "' WHERE cedula = " + dni;
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

	public ArrayList<Client> searchAll() {
		String query;
		query = "SELECT * FROM CLIENTE";
		ArrayList<Client> clients = new ArrayList<Client>();
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			Statement stmt;
			stmt = conect.createStatement();
			ResultSet record = stmt.executeQuery(query);
			while(record.next()) {
				client = new Client();
				client.setDni(record.getInt("cedula"));
				client.setName(record.getString("nombre"));
				clients.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}
	
	public Client searchByDni(int dni) {
		String query;
		query = "SELECT * FROM CLIENTE WHERE cedula = " + dni;
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			Statement stmt;
			stmt = conect.createStatement();
			ResultSet record = stmt.executeQuery(query);
			if(record.next()) {
				client = new Client();
				client.setDni(record.getInt("cedula"));
				client.setName(record.getString("nombre"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}
	
	public ArrayList<Client> searchByName(String name) {
		String query;
		query = "SELECT * FROM CLIENTE WHERE nombre LIKE '%" + name + "%'";
		ArrayList<Client> clients = new ArrayList<Client>();
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			Statement stmt;
			stmt = conect.createStatement();
			ResultSet record = stmt.executeQuery(query);
			while(record.next()) {
				client = new Client();
				client.setDni(record.getInt("cedula"));
				client.setName(record.getString("nombre"));
				clients.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}
	
	//Metodos get y set
	public Connection getConect() {
		return conect;
	}

	public void setConect(Connection conect) {
		this.conect = conect;
	}
}
