package org.boksan.dao;

import java.util.ArrayList;

import org.boksan.model.Criteria;
import org.boksan.model.Product_groupDTO;
import org.boksan.model.Product_selectDTO;
import org.boksan.model.RecipeDTO;
import org.boksan.model.Recipe_addDTO;

public interface RecipeDao {
	//������ ��ǰ�з� ã��
	public ArrayList<Product_groupDTO>recipe_add_select();
	//������ ��ǰ�з��� ���� ��ǰ�̸� ã��
	public ArrayList<Product_selectDTO>recipe_add_pselect(String data);
	
	//�������߰�
	public void recipe_add_insert(Recipe_addDTO rdto);
	
	//�������߰�_�����(�������̺�)
	public void recipe_add_insert_material(Recipe_addDTO rdto);
	
	//�����Ǽ���post
	public void recipe_update_post(Recipe_addDTO rdto);
	
	//�����Ǽ���post_�����_����
	public void recipe_update_post_material_d(Recipe_addDTO rdto);
	
	//�����Ǽ���post_�����_����
	public void recipe_update_post_material_i(Recipe_addDTO rdto);
	
	//������ ���
	public ArrayList<Recipe_addDTO> recipe_inquiry(Criteria cri);
	
	//������ ����
	public void recipe_delete(String recipe_code);
	
	//������ �˻���� ��ȸ
	public ArrayList<Recipe_addDTO> recipe_inquiry_search(String search_text);
	
	//����¡ ó���� ���� ��ü�Ǽ�
	public int getTotalCount(Criteria cri);
	
	//������ ��
	public ArrayList<Recipe_addDTO> recipe_detail(int rc);
	
	//������ ����
	public ArrayList<Recipe_addDTO> recipe_update_get(int product_code);
}
