/**
 * 
 */
package com.tiendafer.interfaces;

import java.util.ArrayList;

import com.tiendafer.model.ProductSold;

/**
 * @author Jonatan
 *
 */
public interface ProductSoldCRUD {

	public boolean createProductSold(ProductSold productSold);
	
	public ArrayList<ProductSold> searchAll();
	
	public ArrayList<ProductSold> searchByBill(int code);
	
}
