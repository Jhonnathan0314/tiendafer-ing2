package com.tiendafer.model;


public class Product {
	//Declaracion de varibales
	private int code;
	private String name;
	private int value;
	private String change;
	private int quantityAvailable;

	private Section section;

	//Metodo constructor
	public Product(int code, String name, int value, String change, int quantityAvailable) {
		this.code = code;
		this.name = name;
		this.value = value;
		this.change = change;
		this.quantityAvailable = quantityAvailable;
	}

	public Product() {

	}

	public void addSection(Section section) {
		this.section = section;
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

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}

	public int getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
}
