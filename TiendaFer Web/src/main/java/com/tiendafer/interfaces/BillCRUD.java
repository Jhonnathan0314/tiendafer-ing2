/**
 * 
 */
package com.tiendafer.interfaces;

import java.util.ArrayList;

import com.tiendafer.model.Bill;

/**
 * @author Jonatan
 *
 */
public interface BillCRUD {
	
	public boolean createBill(Bill clientBill);
	
	public ArrayList<Bill> searchAll();
	
	public int searchLastBill();
	
	public ArrayList<Bill> searchByClient(int dni);
	
	public ArrayList<Bill> searchByDate(String date);

	public Bill searchByCode(int code);

}
