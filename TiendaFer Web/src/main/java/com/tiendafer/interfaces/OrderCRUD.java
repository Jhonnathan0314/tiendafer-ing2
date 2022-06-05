/**
 * 
 */
package com.tiendafer.interfaces;

import java.util.ArrayList;

import com.tiendafer.model.Order;

/**
 * @author Jonatan
 *
 */
public interface OrderCRUD {

	public boolean createOrder(Order order);
	
	public ArrayList<Order> searchAll();
	
	public int searchLastOrder();
	
	public ArrayList<Order> searchByProvider(String nit);
	
	public ArrayList<Order> searchByDate(String date);
	
	public Order searchByCode(int code);
	
}
