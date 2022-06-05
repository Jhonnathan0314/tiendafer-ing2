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
import com.tiendafer.interfaces.SectionCRUD;
import com.tiendafer.model.Section;

/**
 * @author Jonatan
 *
 */
public class SectionDAO implements SectionCRUD {

	private Section section;

	private Connection conect = null;

	public SectionDAO() {
		section = new Section();
	}

	//Metodos propios
	public boolean createSection(Section section) {
		String query;
		query = "INSERT INTO SECCION VALUES(default, '"+section.getName()+"'"+")";
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

	public boolean updateSection(int code, String newName) {
//		if(searchByName(newName) == null) {
			String query;
			query = "UPDATE SECCION SET nombre = '" + newName + "' WHERE codigo = " + code;
			Statement stmt;
			Conexion conexion = new Conexion();
			setConect(conexion.getConexion());
			try {
				stmt = conect.createStatement();
				stmt.executeUpdate(query);
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
//		}else {
//			return false;
//		}
	}

	public Section searchByCode(int code) {
		String query;
		query = "SELECT * FROM SECCION WHERE codigo = " + code;
		Statement stmt;
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		section = new Section();
		try {
			stmt = conect.createStatement();
			ResultSet record = stmt.executeQuery(query);
			if(record.next()) {
				section.setCode(record.getInt("codigo"));
				section.setName(record.getString("nombre"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al consultar: SQLException");
			e.printStackTrace();
		}
		return section;
	}

	public ArrayList<Section> searchByName(String name) {
		String query;
		query = "SELECT * FROM SECCION WHERE nombre = " + name;
		Statement stmt;
		ArrayList<Section> sections = new ArrayList<Section>();
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			stmt = conect.createStatement();
			ResultSet record = stmt.executeQuery(query);
			while(record.next()) {
				section = new Section();
				section.setCode(record.getInt("codigo"));
				section.setName(record.getString("nombre"));
				sections.add(section);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al consultar: SQLException");
			e.printStackTrace();
		}
		return sections;
	}

	public ArrayList<Section> searchAll() {
		String query;

		query = "SELECT * FROM SECCION";

		ArrayList<Section> result = new ArrayList<Section>();
		Statement stmt;
		Conexion conexion = new Conexion();
		setConect(conexion.getConexion());
		try {
			stmt = conect.createStatement();
			ResultSet record = stmt.executeQuery(query);
			while(record.next()) {
				section = new Section();
				section.setCode(record.getInt("codigo"));
				section.setName(record.getString("nombre"));
				result.add(section);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al consultar: SQLException");
			e.printStackTrace();
		}
		return result;
	}

	public boolean attributeIsInt(String attribute) {
		try {
			Integer.parseInt(attribute);
			return true;
		} catch (NumberFormatException e) {
			// TODO: handle exception
			return false;
		}
	}

	public Connection getConect() {
		return conect;
	}

	public void setConect(Connection conect) {
		this.conect = conect;
	}
}
