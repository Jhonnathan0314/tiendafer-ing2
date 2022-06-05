package com.tiendafer.model;

public class Section {
	//Declaracion de variables
	private int code;
	private String name;

	//Metodo constructor
	public Section(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public Section() {

	}

	//Metodos Get y Set
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
