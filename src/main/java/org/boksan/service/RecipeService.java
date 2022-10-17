package org.boksan.service;

import java.util.ArrayList;

import org.boksan.model.Product_groupDTO;
import org.boksan.model.Product_selectDTO;
import org.boksan.model.Recipe_addDTO;

public interface RecipeService {

	public ArrayList<Product_groupDTO>recipe_add_select();
	
	public ArrayList<Product_selectDTO>recipe_add_pselect(String data);
	
	//�������߰�
	public void recipe_add_insert(Recipe_addDTO rdto);
	
	//������ ��� ��ȸ
	public ArrayList<Recipe_addDTO> recipe_inquiry();
	
	//������ ����
	public void recipe_delete(String recipe_code);
	
	//������ �˻� ��� ��ȸ
	public ArrayList<Recipe_addDTO> recipe_inquiry_search(String search_text);
}
