/**
 * 
 */
package com.tiendafer.interfaces;

import java.util.ArrayList;

import com.tiendafer.model.OrderDetail;

/**
 * @author Jonatan
 *
 */
public interface OrderDetailCRUD {

	public boolean createOrderDetail(OrderDetail orderDetail);
	
	public ArrayList<OrderDetail> searchAll();
	
	public ArrayList<OrderDetail> searchByOrder(int code);
	
}
