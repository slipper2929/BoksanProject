package org.boksan.dao;

import java.util.ArrayList;
import java.util.List;

import org.boksan.model.Product_groupDTO;
import org.boksan.model.Product_selectDTO;
import org.boksan.model.Recipe_addDTO;

public interface RecipeDao {

	public ArrayList<Product_groupDTO>recipe_add_select();
	
	public ArrayList<Product_selectDTO>recipe_add_pselect(String data);
	
	//�������߰�
	public void recipe_add_insert(Recipe_addDTO rdto);
	
	//�������߰�_�����(�������̺�)
	public void recipe_add_insert_material(Recipe_addDTO rdto);
	
	//������ ���
	public ArrayList<Recipe_addDTO> recipe_inquiry();
	
	//������ ����
	public void recipe_delete(String recipe_code);
	
	//������ �˻���� ��ȸ
	public ArrayList<Recipe_addDTO> recipe_inquiry_search(String search_text);
	
}
