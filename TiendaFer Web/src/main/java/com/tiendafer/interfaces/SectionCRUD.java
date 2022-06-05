/**
 * 
 */
package com.tiendafer.interfaces;

import java.util.ArrayList;

import com.tiendafer.model.Section;

/**
 * @author Jonatan
 *
 */
public interface SectionCRUD {
	
	public boolean createSection(Section section);
	
	public boolean updateSection(int code, String newName);
	
	public ArrayList<Section> searchAll();
	
	public Section searchByCode(int code);
	
	public ArrayList<Section> searchByName(String name);
	
}
