package com.tiendafer.model;

public class Client {
	//Declaracion de variables
	private int dni;
	private String name;
	
	//Metodo constructor
	public Client(int dni, String name) {
		this.dni = dni;
		this.name = name;
	}

	public Client() {

	}

	//Metodos Get y Set
	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
