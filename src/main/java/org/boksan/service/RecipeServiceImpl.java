package org.boksan.service;

import java.util.ArrayList;

import org.boksan.dao.RecipeDao;
import org.boksan.model.Criteria;
import org.boksan.model.Product_groupDTO;
import org.boksan.model.Product_selectDTO;
import org.boksan.model.RecipeDTO;
import org.boksan.model.Recipe_addDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService{
	
	@Autowired
	RecipeDao rdao;
	//������ ��ǰ�з� ã��
	public ArrayList<Product_groupDTO>recipe_add_select(){
		
		return rdao.recipe_add_select();
		
	}
	//������ ��ǰ�з������� ��ǰ�̸�
	public ArrayList<Product_selectDTO>recipe_add_pselect(String data){
		
		return rdao.recipe_add_pselect(data);
		
	}
	
	//�������߰�
	public void recipe_add_insert(Recipe_addDTO rdto) {
		
		rdao.recipe_add_insert(rdto);
		
		for(int i = 0; i < rdto.getProduct_code_list().size(); i++) {
			rdto.setProduct_code(rdto.getProduct_code_list().get(i).getProduct_code());
			rdto.setMaterial_num(rdto.getMaterial_num_list().get(i).getMaterial_num());
			
			rdao.recipe_add_insert_material(rdto);
		}
		
		
		System.out.println("ù��°��� ��ǰ�ڵ� : "+rdto.getProduct_code_list().get(0).getProduct_code());
		System.out.println("ù��°��� ��ǰ�߷� : "+rdto.getMaterial_num_list().get(0).getMaterial_num());
		System.out.println("�ι�°��� ��ǰ�ڵ� : "+rdto.getProduct_code_list().get(1).getProduct_code());
		System.out.println("�ι�°��� ��ǰ�߷� : "+rdto.getProduct_code_list().get(1).getMaterial_num());
		
		
	}
	
	//�����Ǽ���post
	public void recipe_update_post(Recipe_addDTO rdto) {
		rdao.recipe_update_post(rdto);
		
		rdao.recipe_update_post_material_d(rdto);
		
		for(int i = 0; i < rdto.getProduct_code_list().size(); i++) {
			rdto.setProduct_code(rdto.getProduct_code_list().get(i).getProduct_code());
			rdto.setMaterial_num(rdto.getMaterial_num_list().get(i).getMaterial_num());
			
			rdao.recipe_update_post_material_i(rdto);
		}
		
	}
	
	//������ ��� ��ȸ
	public ArrayList<Recipe_addDTO> recipe_inquiry(Criteria cri){
		return rdao.recipe_inquiry(cri);
	}
	
	//������ ����
	public void recipe_delete(String recipe_code) {
		
		rdao.recipe_delete(recipe_code);
		
	}
	
	//������ �˻� ��� ��ȸ
	public ArrayList<Recipe_addDTO> recipe_inquiry_search(String search_text){
		return rdao.recipe_inquiry_search(search_text);
	}
	
	//����¡ ó���� ���� ��ü�Ǽ�
	public int getTotalCount(Criteria cri) {
		
		return rdao.getTotalCount(cri);
		
	}
	
	//������ ��
	public ArrayList<Recipe_addDTO> recipe_detail(int rc) {
		
		return rdao.recipe_detail(rc);
		
	}
	
	//�����Ǽ���
	public ArrayList<Recipe_addDTO> recipe_update_get(int product_code) {
		
		return rdao.recipe_update_get(product_code);
		
	}
}
