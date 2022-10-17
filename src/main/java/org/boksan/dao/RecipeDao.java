package org.boksan.dao;

import java.util.ArrayList;
import java.util.List;

import org.boksan.model.Product_groupDTO;
import org.boksan.model.Product_selectDTO;
import org.boksan.model.Recipe_addDTO;

public interface RecipeDao {

	public ArrayList<Product_groupDTO>recipe_add_select();
	
	public ArrayList<Product_selectDTO>recipe_add_pselect(String data);
	
	//레시피추가
	public void recipe_add_insert(Recipe_addDTO rdto);
	
	//레시피추가_재료목록(맵핑테이블)
	public void recipe_add_insert_material(Recipe_addDTO rdto);
	
}
