package org.boksan.service;

import java.util.ArrayList;

import org.boksan.model.Product_groupDTO;
import org.boksan.model.Product_selectDTO;

public interface RecipeService {

	public ArrayList<Product_groupDTO>recipe_add_select();
	
	public ArrayList<Product_selectDTO>recipe_add_pselect(String data);
}
