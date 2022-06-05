/**
 * 
 */
package com.tiendafer.interfaces;

import java.util.ArrayList;

import com.tiendafer.model.Payment;

/**
 * @author Jonatan
 *
 */
public interface PaymentCRUD {

	public ArrayList<Payment> consultPayment(String paymentNumber);
	
}
