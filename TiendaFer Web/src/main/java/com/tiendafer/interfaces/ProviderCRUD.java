/**
 * 
 */
package com.tiendafer.interfaces;

import java.math.BigInteger;
import java.util.ArrayList;

import com.tiendafer.model.Provider;

/**
 * @author Jonatan
 *
 */
public interface ProviderCRUD {

	public boolean createProvider(Provider provider);
	
	public boolean updateSupplierName(BigInteger nit, String supplierName);

	public boolean updateSellerName(BigInteger nit, String sellerName);
	
	public ArrayList<Provider> searchAll();
	
	public Provider searchByNit(BigInteger nit);

	public ArrayList<Provider> searchBySupplierName(String supplierName);
		
	public ArrayList<Provider> searchBySellerName(String sellerName);

}
