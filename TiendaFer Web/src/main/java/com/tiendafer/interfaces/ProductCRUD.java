/**
 * 
 */
package com.tiendafer.interfaces;

import java.util.ArrayList;

import com.tiendafer.model.Product;

/**
 * @author Jonatan
 *
 */
public interface ProductCRUD {

	public boolean createProduct(Product product);

	public boolean updateName(int code, String newName);

	public boolean updateValue(int code, int newValue);

	public boolean updateChange(int code, String newChange);

	public boolean updateQuantity(int code, int newQuantity);

	public ArrayList<Product> searchAll();
	
	public Product searchByCode(int code);
	
	public ArrayList<Product> searchByName(String name);

	public ArrayList<Product> searchByValue(int value);
	
	public ArrayList<Product> searchScarceProducts();
	
	public ArrayList<Product> searchProductsBySection(String sectionCode);

}
