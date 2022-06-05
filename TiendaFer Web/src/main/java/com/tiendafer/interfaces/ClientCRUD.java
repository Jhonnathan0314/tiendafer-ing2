/**
 * 
 */
package com.tiendafer.interfaces;

import java.util.ArrayList;

import com.tiendafer.model.Client;

/**
 * @author Jonatan
 *
 */
public interface ClientCRUD {

	public boolean createClient(Client client);
	
	public boolean updateName(int dni, String newName);
	
	public ArrayList<Client> searchAll();
	
	public Client searchByDni(int dni);
	
	public ArrayList<Client> searchByName(String name);
	
}
